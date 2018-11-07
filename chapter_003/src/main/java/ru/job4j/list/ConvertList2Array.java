package ru.job4j.list;

import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (int) Math.ceil(list.size() / (double) rows);
        int[][] array = new int[rows][cells];
        int cell = 0, row = 0;
        for (int value: list) {
            array[row][cell++] = value;
            if (cell == cells) {
                row++;
                cell = 0;
            }
        }
        return array;
    }
}
