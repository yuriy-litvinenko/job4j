package ru.job4j.lsp;

import java.util.Calendar;

class Milk extends Food {
    Milk(String name, Calendar createDate, Calendar expireDate, double price, double discount) {
        super(name, createDate, expireDate, price, discount);
    }
}
