package ru.job4j.parser;

import org.apache.log4j.Level;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

class ParseJSOUP {
    private static final String URL_MAIN = "https://www.sql.ru/forum/job/";

    private static Document getPage(String url) {
        Document result = null;
        try {
            result = Jsoup.parse(new URL(url), 10000);
        } catch (Exception e) {
            SqlRuParser.log(Level.ERROR, e.getMessage());
        }
        return result;
    }

    List<Vacancy> getVacancies(Date lastRunDate) {
        List<Vacancy> vacancies = new ArrayList<>();
        DateParser dateParser = new DateParser();
        boolean stopCycle = false;
        for (int i = 1; !stopCycle; i++) {
            Document forumPage = getPage(URL_MAIN + i);
            Element forumTable = Objects.requireNonNull(forumPage).select("table[class=forumTable]").first();
            Elements topicsData = forumTable.select("tr");
            topicsData.remove(0);
            for (Element topic : topicsData) {
                Date topicDate = dateParser.getDate(topic.select("td[class=altCol]").get(1).text());
                Element topicHead = topic.select("td[class=postslisttopic]").first().select("a").first();
                String topicTitle = topicHead.text();
                String titleImportant = topic.select("td[class=postslisttopic]").first().text();
                if (!titleImportant.contains("Важно: ")) {
                    if (topicDate.after(lastRunDate)) {
                        if (topicTitle.contains("Java") && !topicTitle.contains("JavaScript") && !topicTitle.contains("Java Script")) {
                            String topicLink = topicHead.attr("href");
                            Document topicPage = getPage(topicLink);
                            String topicText = Objects.requireNonNull(topicPage).select("table[class=msgTable]").first().select("td[class=msgBody]").eq(1).text();
                            vacancies.add(new Vacancy(topicTitle, topicText, topicLink));
                        }
                    } else {
                        stopCycle = true;
                        break;
                    }
                }
            }
        }
        return vacancies;
    }
}
