package ru.job4j.array;

/**
 * Задание 6.3. Массив заполнен true или false
 * @author Юрий Литвиненко
 * @since 22.06.2018
 */
public class Check {
    public boolean mono(boolean[] data) {
        boolean result = false, temp = data[0];
        for (boolean value:data) {
            if (value == temp) {
                result = true;
            } else {
                result = false;
                break;
            }
        }
        return result;
    }
}
