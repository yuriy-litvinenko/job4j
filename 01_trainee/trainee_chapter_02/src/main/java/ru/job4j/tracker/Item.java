package ru.job4j.tracker;

public class Item {
    private String id;
    private String name;
    private String description;
    private long create;

    public Item() {

    }

    Item(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }

    Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "ID заявки: " + this.getId()
                + System.lineSeparator()
                + "Имя заявки: " + this.getName()
                + System.lineSeparator()
                + "Описание заявки: " + this.getDescription()
                + System.lineSeparator()
                + "--------------------------------------------------";
    }

    public String getName() {
        return this.name;
    }

    String getDescription() {
        return this.description;
    }

    public long getCreate() {
        return this.create;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
