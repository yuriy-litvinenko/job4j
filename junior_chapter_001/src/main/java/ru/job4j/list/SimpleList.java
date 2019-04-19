package ru.job4j.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleList<E> implements Iterable<E> {
    private Object[] container = new Object[2];
    private int pos = 0;
    private int modCount = 0;

    private void checkLength() {
        if (pos == container.length) {
            container = Arrays.copyOf(container, container.length * 2);
        }
    }

    public void add(E value) {
        checkLength();
        container[pos++] = value;
        modCount++;
    }

    public E get(int index) {
        if (index < pos) {
            return (E) container[index];
        }
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            int expectedModCount = modCount;
            int posIt = 0;

            @Override
            public boolean hasNext() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                return posIt < pos;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) container[posIt++];
            }
        };
    }
}
