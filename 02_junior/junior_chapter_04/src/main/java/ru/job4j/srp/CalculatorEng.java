package ru.job4j.srp;

class CalculatorEng extends Calculator {

    static double sin(double value) {
        return Math.sin(Math.toRadians(value));
    }

    static double cos(double value) {
        return Math.cos(Math.toRadians(value));
    }

    static double tg(double value) {
        return Math.tan(Math.toRadians(value));
    }

    static double ctg(double value) {
        return Math.cos(Math.toRadians(value)) / Math.sin(Math.toRadians(value));
    }
}
