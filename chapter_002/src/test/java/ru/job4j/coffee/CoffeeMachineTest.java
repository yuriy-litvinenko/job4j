package ru.job4j.coffee;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CoffeeMachineTest {
    @Test
    public void changesTest() {
        CoffeeMachine machine = new CoffeeMachine();
        int[] actual = machine.changes(50, 35);
        int[] expected = {10, 5};
        assertThat(actual, is(expected));
    }
}
