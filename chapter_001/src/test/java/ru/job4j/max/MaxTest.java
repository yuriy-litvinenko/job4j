package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {

    //Проверка метода вычисления максимума из двух чисел
    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenSecondLessFirst() {
        Max maxim = new Max();
        int result = maxim.max(3, 2);
        assertThat(result, is(3));
    }

    @Test
    public void whenFirstEqualSecond() {
        Max maxim = new Max();
        int result = maxim.max(2, 2);
        assertThat(result, is(2));
    }

    //Проверка метода вычисления максимума из трех чисел
    @Test
    public void whenFirstLargerOther() {
        Max maxim = new Max();
        int result = maxim.max(3, 2, 1);
        assertThat(result, is(3));
    }

    @Test
    public void whenSecondLargerOther() {
        Max maxim = new Max();
        int result = maxim.max(1, 3, 2);
        assertThat(result, is(3));
    }

    @Test
    public void whenThirdLargerOther() {
        Max maxim = new Max();
        int result = maxim.max(2, 1, 3);
        assertThat(result, is(3));
    }
}
