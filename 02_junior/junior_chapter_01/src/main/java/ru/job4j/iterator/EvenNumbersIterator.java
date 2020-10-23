package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator {

    private final int[] values;
    private int index = 0;

    EvenNumbersIterator(final int[] values) {
        this.values = values;
    }

    private boolean isEven(int value) {
        return value % 2 == 0;
    }

    @Override
    public boolean hasNext() {
        while (index != values.length) {
            if (isEven(values[index])) {
                return true;
            }
            index++;
        }
        return false;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return values[index++];
    }
}
