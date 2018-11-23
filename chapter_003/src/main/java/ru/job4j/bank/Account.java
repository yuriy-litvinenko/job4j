package ru.job4j.bank;

public class Account {
    private double value;
    private String requisites;

    public Account(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public double getValue() {
        return value;
    }

    public String getRequisites() {
        return requisites;
    }

    public boolean transfer(Account destAcc, double amount) {
        boolean result = false;
        if (amount > 0 && amount < this.value && destAcc != null) {
            this.value -= amount;
            destAcc.value += amount;
            result = true;
        }
        return result;
    }
}
