package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void whenArrayContainsDuplicatesThenDropIt() {
        String[] input = {"1", "3", "4", "5", "5", "2", "3", "5", "2", "4", "1"};
        String[] expect = {"1", "2", "3", "4", "5"};
        ArrayDuplicate duplicate = new ArrayDuplicate();
        String[] result = duplicate.removeDuplicates(input);
        assertThat(result, arrayContainingInAnyOrder(expect));
    }
}
