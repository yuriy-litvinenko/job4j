package ru.job4j.lsp;

import java.util.Calendar;

class Banana extends Food implements Vegetable {

    Banana(String name, Calendar createDate, Calendar expireDate, double price, double discount) {
        super(name, createDate, expireDate, price, discount);
    }
}
