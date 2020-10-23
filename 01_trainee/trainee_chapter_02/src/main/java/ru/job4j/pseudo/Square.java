package ru.job4j.pseudo;

public class Square implements Shape {
    public String draw() {
        return "+++++++"
                + System.lineSeparator()
                + "+++++++"
                + System.lineSeparator()
                + "+++++++"
                + System.lineSeparator()
                + "+++++++";
    }
}
