package ru.job4j.array;

/**
 * Контрольное задание.
 * Заполнение массива данными из двух других отсортированных массивов с соблюдением сортировки.
 *
 * @author Юрий Литвиненко
 * @since 03.07.2018
 */
class ArraySort {

    int[] arraySumSort(int[] ar1, int[] ar2) {
        int[] ar3 = new int[ar1.length + ar2.length];
        for (int i1 = 0, i2 = 0, i3 = 0; i3 < ar3.length; i3++) {
            if (i1 == ar1.length) {
                ar3[i3] = ar2[i2++];
            } else if (i2 == ar2.length) {
                ar3[i3] = ar1[i1++];
            } else if (ar1[i1] <= ar2[i2]) {
                ar3[i3] = ar1[i1++];
            } else {
                ar3[i3] = ar2[i2++];
            }
        }
        return ar3;
    }
}
