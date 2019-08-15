package ru.job4j.parser;

import java.util.Objects;

public class Vacancy {
    private String name;
    private String text;
    private String link;

    Vacancy(String name, String text, String link) {
        this.name = name;
        this.text = text;
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Vacancy{"
                + "name='" + name + '\''
                + ", link='" + link + '\''
                + ", text='" + text + '\''
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vacancy vacancy = (Vacancy) o;
        return name.equals(vacancy.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
