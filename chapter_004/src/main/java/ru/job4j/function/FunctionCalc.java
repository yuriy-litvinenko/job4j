package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionCalc {
    List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> valueList = new ArrayList<>();
        for (double index = start; index != end; index++) {
            valueList.add(func.apply(index));
        }
        return valueList;
    }
}
