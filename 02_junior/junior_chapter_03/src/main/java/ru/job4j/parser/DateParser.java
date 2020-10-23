package ru.job4j.parser;

import org.apache.log4j.Level;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

class DateParser {
    private SimpleDateFormat dateFormat;

    DateParser() {
        init();
    }

    private void init() {
        String[] months = {"янв", "фев", "мар", "апр", "май", "июн", "июл", "авг", "сен", "окт", "ноя", "дек"};
        Locale ru = new Locale("ru");
        DateFormatSymbols symbols = DateFormatSymbols.getInstance(ru);
        symbols.setMonths(months);
        dateFormat = new SimpleDateFormat("d MMM y, HH:mm", ru);
        dateFormat.setDateFormatSymbols(symbols);
    }

    Date getDate(String date) {
        Date result = null;
        Calendar c;
        String day, time;
        int hour, minute;
        String[] splitDate = date.split(",", 2);
        day = splitDate[0];
        time = splitDate[1].replaceAll("\\s", "");
        String[] splitTime = time.split(":", 2);
        hour = Integer.valueOf(splitTime[0]);
        minute = Integer.valueOf(splitTime[1]);
        if (day.equals("сегодня")) {
            c = Calendar.getInstance();
            c.set(Calendar.HOUR_OF_DAY, hour);
            c.set(Calendar.MINUTE, minute);
            result = c.getTime();
        } else if (day.equals("вчера")) {
            c = Calendar.getInstance();
            c.add(Calendar.DATE, -1);
            c.set(Calendar.HOUR_OF_DAY, hour);
            c.set(Calendar.MINUTE, minute);
            result = c.getTime();
        } else {
            try {
                result = dateFormat.parse(date);
            } catch (Exception e) {
                SqlRuParser.log(Level.ERROR, e.getMessage());
            }
        }
        return result;
    }
}
