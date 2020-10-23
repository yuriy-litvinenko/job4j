package ru.job4j.function;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FunctionCalcTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        FunctionCalc function = new FunctionCalc();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        FunctionCalc function = new FunctionCalc();
        List<Double> result = function.diapason(3, 6, x -> 2 * Math.pow(x, 2) + 3 * x + 1);
        List<Double> expected = Arrays.asList(28D, 45D, 66D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLogarithmicFunctionThenLogarithmicResults() {
        FunctionCalc function = new FunctionCalc();
        List<Double> result = function.diapason(4, 7, x -> Math.log(x) / Math.log(2));
        List<Double> expected = Arrays.asList(2D, 2.321928094887362D, 2.584962500721156D);
        assertThat(result, is(expected));
    }
}
