package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

class ConvertMatrix2List {
    List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] row : array) {
            for (int cell : row) {
                list.add(cell);
            }
        }
        return list;
    }
}
