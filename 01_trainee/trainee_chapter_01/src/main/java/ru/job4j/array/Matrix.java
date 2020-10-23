package ru.job4j.array;

/**
 * Задание 6.6. Двухмерный массив. Таблица умножения.
 * @author Юрий Литвиненко
 * @since 25.06.2018
 */
class Matrix {
    int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }
}
