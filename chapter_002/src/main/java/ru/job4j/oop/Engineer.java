package ru.job4j.oop;

public class Engineer extends Profession {
    public House buildHouse(Plan plan) {
        return new House();
    }
}
