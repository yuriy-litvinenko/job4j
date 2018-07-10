package ru.job4j.tracker;

import java.util.*;

class Tracker {
    private final Item[] items = new Item[10];
    private int position = 0;
    private static final Random RN = new Random();

    void add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
    }

    void replace(String id, Item item) {
        for (int index = 0; index != items.length; index++) {
            if (items[index] != null && items[index].getId().equals(id)) {
                items[index] = item;
                break;
            }
        }
    }

    void delete(String id) {
        for (int index = 0; index != items.length; index++) {
            if (items[index] != null && items[index].getId().equals(id)) {
                System.arraycopy(items, index + 1, items, index, items.length - index - 1);
                break;
            }
        }
    }

    Item[] getAll() {
        Item[] result = new Item[position];
        for (int index = 0; index != this.position; index++) {
            result[index] = this.items[index];
        }
        return result;
    }

    Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    Item[] findByName(String key) {
        Item[] result = new Item[items.length];
        for (int index = 0, indexres = 0; index != items.length; index++) {
            if (items[index] != null && items[index].getName().equals(key)) {
                result[indexres++] = items[index];
            }
        }
        return result;
    }

    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
    }


}
