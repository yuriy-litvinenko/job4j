package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.List;

class ControlQuality {

    private List<Store> storage = new ArrayList<>();

    boolean putFood(Food food) {
        boolean result = false;
        for (Store store : storage) {
            if (store.accept(food) && store.isNotFull()) {
                store.put(food);
                result = true;
                break;
            }
        }
        return result;
    }

    void addWarehouse(int size) {
        storage.add(new Warehouse(size));
    }

    void addShop(int size) {
        storage.add(new Shop(size));
    }

    void addTrash(int size) {
        storage.add(new Trash(size));
    }

    List<Store> getStorage() {
        return storage;
    }
}
