package ru.job4j.array;

/**
 * Задание 6.7. Квадратный массив заполнен true или false по диагоналям.
 * @author Юрий Литвиненко
 * @since 26.06.2018
 */
public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = true, value = data[0][0];
        for (int i = 0; (i < data.length) && result; i++) {
            for (int j = 0; (j < data[i].length) && result; j++) {
                if ((i == j || j == data[i].length - i - 1) && data[i][j] != value) {
                    result = false;}
            }
        }
        return result;
    }
}
