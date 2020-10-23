package ru.job4j.matrix;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertTest {
    @Test
    public void convertArrayMatrixToList() {
        Integer[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        List<Integer> result = new Convert().arrToList(matrix);
        List<Integer> expect = List.of(1, 2, 3, 4, 5, 6);
        assertThat(result, is(expect));
    }
}
