package ru.job4j.array;

/**
 * Задание 6.3. Массив заполнен true или false
 * @author Юрий Литвиненко
 * @since 22.06.2018
 */
public class Check {
    public boolean mono(boolean[] data) {
        boolean result = false;
        for (boolean value:data) {
            if (value) {
                result = true;
            } else {
                result = false;
                break;
            }
        }
        return result;
    }
}
