package ru.job4j.array;

import java.util.Arrays;

/**
 * Задание 6.8. Удаление дубликатов в массиве.
 * @author  Юрий Литвиненко
 * @since 25.06.2018
 */
class ArrayDuplicate {
    String[] removeDuplicates(String[] array) {
        int unique = array.length;
        for (int out = 0; out < unique; out++) {
            for (int in = out + 1; in < unique; in++) {
                if (array[out].equals(array[in])) {
                    array[in] = array[unique - 1];
                    unique--;
                    in--;
                }
            }
        }
        return Arrays.copyOf(array, unique);
    }
}
