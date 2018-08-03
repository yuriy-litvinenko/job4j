package ru.job4j.pseudo;

public class Triangle implements Shape {
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("   +   ");
        pic.append(System.lineSeparator());
        pic.append("  +++  ");
        pic.append(System.lineSeparator());
        pic.append(" +++++ ");
        pic.append(System.lineSeparator());
        pic.append("+++++++");
        return pic.toString();
    }
}