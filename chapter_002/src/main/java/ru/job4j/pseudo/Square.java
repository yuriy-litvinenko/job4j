package ru.job4j.pseudo;

public class Square implements Shape{
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("+++++++\n");
        pic.append("+++++++\n");
        pic.append("+++++++\n");
        pic.append("+++++++");
        return pic.toString();
    }
}
