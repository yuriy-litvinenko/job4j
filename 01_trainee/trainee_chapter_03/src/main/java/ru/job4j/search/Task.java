package ru.job4j.search;

class Task {
    private String desc;
    private int priority;

    Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }

    String getDesc() {
        return desc;
    }

    int getPriority() {
        return priority;
    }
}
