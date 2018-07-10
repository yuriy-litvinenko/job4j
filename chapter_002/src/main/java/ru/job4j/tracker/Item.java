package ru.job4j.tracker;

public class Item {
    private String id;
    public String name;
    private String description;
    private long create;

    public Item() {

    }

    Item(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public long getCreate() {
        return this.create;
    }

    String getId() {
        return this.id;
    }

    void setId(String id) {
        this.id = id;
    }
}
