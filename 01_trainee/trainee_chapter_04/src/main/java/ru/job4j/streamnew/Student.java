package ru.job4j.streamnew;

public class Student {
    private String name;
    private int scope;

    Student(String name, int scope) {
        this.name = name;
        this.scope = scope;
    }

    int getScope() {
        return scope;
    }
}
