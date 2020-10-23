package ru.job4j.isp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MenuItem {

    private final String key;
    private final String name;
    private List<MenuItem> childList = new ArrayList<>();
    private int level;
    private UserAction action = new UserActionList.DefaultAction();

    MenuItem(String key, String name) {
        this.key = key;
        this.name = name;
        this.level = 0;
    }

    MenuItem(String key, String name, int level) {
        this.key = key;
        this.name = name;
        this.level = level;
    }

    void addChild(MenuItem menuItem) {
        childList.add(menuItem);
    }

    List<MenuItem> getChildList() {
        return childList;
    }

    int getLevel() {
        return this.level;
    }

    void setAction(UserAction action) {
        this.action = action;
    }

    String getKey() {
        return this.key;
    }

    private String info() {
        char[] chars = new char[this.level * 2];
        Arrays.fill(chars, ' ');
        return String.format(new String(chars) + "%s : %s", this.key, this.name);
    }

    void execute() {
        action.execute();
    }

    @Override
    public String toString() {
        return this.info();
    }
}
