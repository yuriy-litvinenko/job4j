package ru.job4j.array;

/**
 * Задание 6.7. Квадратный массив заполнен true или false по диагоналям.
 * @author Юрий Литвиненко
 * @since 26.06.2018
 */
public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = true, value = data[0][0];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (i == j) {
                    if (data[i][j] != value) {result = false;}
                }
                if (j == data[i].length - i - 1) {
                    if (data[i][j] != value) {result = false;}
                }
                if (!result) {break;}
            }
            if (!result) {break;}
        }
        return result;
    }
}
