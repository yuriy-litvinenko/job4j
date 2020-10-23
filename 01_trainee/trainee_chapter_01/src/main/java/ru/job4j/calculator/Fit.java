package ru.job4j.calculator;

/**
 * Программа для расчета идеального веса.
 */
class Fit {

    /**
     * Идеальный вес для мужчины
     * @param height рост
     * @return идеальный вес
     */
    double manWeight(double height) {
        return (height - 100) * 1.15;
    }

    /**
     * Идеальный вес для женщины
     * @param height рост
     * @return идеальный вес
     */
    double womanWeight(double height) {
        return (height - 110) * 1.15;
    }
}

