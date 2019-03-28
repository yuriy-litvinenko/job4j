package ru.job4j.filtration;

public class Student {
    private int score;
    private String lastName;

    public Student(int score) {
        this.score = score;
        this.lastName = null;
    }

    public Student(String lastName) {
        this.score = 0;
        this.lastName = lastName;
    }

    public int getScore() {
        return score;
    }

    public String getLastName() {
        return lastName;
    }
}
