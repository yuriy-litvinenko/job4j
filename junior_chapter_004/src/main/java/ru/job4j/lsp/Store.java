package ru.job4j.lsp;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

abstract class Store {
    private Food[] storageList;
    private boolean full = false;
    private int cur = 0;

    Store(int size) {
        storageList = new Food[size];
    }

    abstract boolean accept(Food food);

    void put(Food food) {
        storageList[cur] = food;
        cur++;
        if (cur == storageList.length) {
            full = true;
        }
    }

    double getProdTime(Calendar createDate, Calendar expireDate) {
        double result;
        long cur = Calendar.getInstance().getTimeInMillis();
        long prod = createDate.getTimeInMillis();
        long exp = expireDate.getTimeInMillis();
        result = (double) TimeUnit.MILLISECONDS.toDays(Math.abs(cur - prod)) / TimeUnit.MILLISECONDS.toDays(Math.abs(exp - prod)) * 100;
        return result;
    }

    boolean isNotFull() {
        return !full;
    }

    Food[] getStorageList() {
        return storageList;
    }

    void reInitialization() {
        storageList = new Food[storageList.length];
        this.full = false;
        this.cur = 0;
    }
}
