package ru.job4j.numoper;

import java.util.List;

class ArrayOperation {
    int operation(List<Integer> array) {
        return array.stream().filter(x -> x % 2 == 0).map(x -> Math.pow(x, 2)).reduce(0.0, (acc, x) -> acc + x).intValue();
    }
}
