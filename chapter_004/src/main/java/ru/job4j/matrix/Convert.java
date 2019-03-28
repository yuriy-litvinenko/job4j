package ru.job4j.matrix;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Convert {
    public List<Integer> arrToList(Integer[][] matrix) {
        return Stream.of(matrix).flatMap(Arrays::stream).collect(Collectors.toList());
    }
}
