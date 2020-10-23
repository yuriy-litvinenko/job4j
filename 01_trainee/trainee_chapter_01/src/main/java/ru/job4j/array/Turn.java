package ru.job4j.array;

/**
 * Задание 6.2. Перевернуть массив.
 * @author Юрий Литвиненко
 * @since 22.06.2018
 */
class Turn {
    int[] turn(int[] array) {
        for (int index = 0, temp; index < array.length / 2; index++) {
            temp = array[index];
            array[index] = array[array.length - index - 1];
            array[array.length - index - 1] = temp;
        }
        return array;
    }
}
