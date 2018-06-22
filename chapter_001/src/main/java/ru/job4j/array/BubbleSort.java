package ru.job4j.array;

/**
 * Задание 6.5. Создать программу для сортировки массива методом перестановки.
 * @author Юрий Литвиненко
 * @since 22.06.2018
 */
public class BubbleSort {
    public int[] sort(int[] array) {
        //В первом цикле задается количество проходов сортировки по массиву
        for (int count = array.length - 1; count > 0; count--) {
            //Во втором цикле производится сортировка массива
            for (int index = 0, temp; index < array.length - 1; index++) {
                if (array[index] > array [index + 1]) {
                    temp = array[index];
                    array[index] = array[index + 1];
                    array[index + 1] = temp;
                }
            }
        }
        return array;
    }
}
