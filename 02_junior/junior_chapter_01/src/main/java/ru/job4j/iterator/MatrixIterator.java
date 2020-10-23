package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIterator implements Iterator {

    private final int[][] values;
    private int i = 0, j = 0;

    MatrixIterator(final int[][] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return values.length - 1 > i;
    }

    @Override
    public Object next() {
        if (values[i].length > j) {
            return values[i][j++];
        } else {
            i++;
            j = 0;
            if (values.length > i) {
                return values[i][j++];
            }
        }
        throw new NoSuchElementException();
    }
}
