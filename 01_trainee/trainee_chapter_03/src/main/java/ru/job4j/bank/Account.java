package ru.job4j.bank;

class Account {
    private double value;
    private String requisites;

    Account(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    double getValue() {
        return value;
    }

    String getRequisites() {
        return requisites;
    }

    boolean transfer(Account destAcc, double amount) {
        boolean result = false;
        if (amount > 0 && amount < this.value && destAcc != null) {
            this.value -= amount;
            destAcc.value += amount;
            result = true;
        }
        return result;
    }
}
