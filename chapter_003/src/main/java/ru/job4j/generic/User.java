package ru.job4j.generic;

public class User {
    private int id;
    private String name, city;

    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public int getId() {
        return id;
    }
}
