package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArraySortTest {
    @Test
    public void whenTwoSortArrayThenOneSumSortArray1() {
        ArraySort arraySort = new ArraySort();
        int[] input1 = new int[] {1, 5, 9, 12, 13, 14};
        int[] input2 = new int[] {0, 2, 3, 5, 7, 9};
        int[] result = arraySort.arraySumSort(input1, input2);
        int[] expect = new int[] {0, 1, 2, 3, 5, 5, 7, 9, 9, 12, 13, 14};
        assertThat(result, is(expect));
    }

    @Test
    public void whenTwoSortArrayThenOneSumSortArray2() {
        ArraySort arraySort = new ArraySort();
        int[] input1 = new int[] {0, 2, 3, 5, 7, 9};
        int[] input2 = new int[] {1, 5, 9, 12, 13, 14};
        int[] result = arraySort.arraySumSort(input1, input2);
        int[] expect = new int[] {0, 1, 2, 3, 5, 5, 7, 9, 9, 12, 13, 14};
        assertThat(result, is(expect));
    }
}
