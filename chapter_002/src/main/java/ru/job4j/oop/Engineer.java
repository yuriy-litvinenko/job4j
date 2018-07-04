package ru.job4j.oop;

public class Engineer extends Profession {
    Engineer(String name) {
        super(name);
    }
    public House buildHouse(Plan plan) {
        return new House();
    }
}
