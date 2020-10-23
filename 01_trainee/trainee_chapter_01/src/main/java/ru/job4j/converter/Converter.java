package ru.job4j.converter;

/**
 * Конвертер валюты.
 */
class Converter {

    /**
     * Конвертируем рубли в евро.
     * @param value рубли
     * @return евро
     */
    int rubleToEuro(int value) {
        return value / 70;
    }

    /**
     * Конвертируем рубли в доллары
     * @param value рубли
     * @return доллары
     */
    int rubleToDollar(int value) {
        return value / 60;
    }

    /**
     * Конвертируем евро в рубли.
     * @param value евро
     * @return рубли
     */
    int euroToRuble(int value) {
        return value * 70;
    }

    /**
     * Конвертируем доллары в рубли
     * @param value доллары
     * @return рубли
     */
    int dollarToRuble(int value) {
        return value * 60;
    }
}

