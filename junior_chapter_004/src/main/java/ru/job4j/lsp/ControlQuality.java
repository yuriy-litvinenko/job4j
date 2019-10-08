package ru.job4j.lsp;

import java.util.*;

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

    void allocationFood(List<Food> foods) {
        for (Food food : foods) {
            this.putFood(food);
        }
    }

    void resort() {
        List<Food> foods = this.getAllFoods();
        this.reInitAll();
        this.allocationFood(foods);
    }

    List<Food> getAllFoods() {
        List<Food> foods = new ArrayList<>();
        for (Store store : storage) {
            Collections.addAll(foods, store.getStorageList());
        }
        foods.removeAll(Collections.singleton(null));
        return foods;
    }

    private void reInitAll() {
        for (Store store : storage) {
            store.reInitialization();
        }
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
