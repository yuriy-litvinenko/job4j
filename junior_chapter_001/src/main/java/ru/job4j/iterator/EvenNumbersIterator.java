package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator {

    private final int[] values;
    private int index = 0;

    public EvenNumbersIterator(final int[] values) {
        this.values = values;
    }

    private boolean isEven(int value) {
        return value % 2 == 0;
    }

    @Override
    public boolean hasNext() {
        for (int indexTmp = index; indexTmp != values.length; indexTmp++) {
            if (isEven(values[indexTmp])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object next() {
        while (index != values.length) {
            if (isEven(values[index])) {
                return values[index++];
            } else {
                index++;
            }
        }
        throw new NoSuchElementException();
    }
}
