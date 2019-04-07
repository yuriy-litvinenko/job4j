package ru.job4j.numoper;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayOperationTest {
    @Test
    public void getEvenSquareSumFromList() {
        List<Integer> array = List.of(1, 2, 3, 4, 5, 6);
        int result = new ArrayOperation().operation(array);
        int expect = 56;
        assertThat(result, is(expect));
    }
}
