package ru.job4j.sort;

public class User implements Comparable<User> {
    private String name;
    private int age;

    User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }

    @Override
    @SuppressWarnings("NullableProblems")
    public int compareTo(User o) {
        return Integer.compare(this.age, o.age);
    }
}
