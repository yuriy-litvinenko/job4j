package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable {
    private Object[] objects;
    private int pos = 0;

    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    public int length() {
        return pos;
    }

    public void add(T model) {
        if (pos < objects.length) {
            objects[pos++] = model;
        }
    }

    void set(int index, T model) {
        if (index < pos) {
            objects[index] = model;
        }
    }

    void remove(int index) {
        if (index < pos) {
            System.arraycopy(objects, index + 1, objects, index, objects.length - 1 - index);
            pos--;
        }
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < pos) {
            return (T) objects[index];
        }
        return null;
    }

    @Override
    @SuppressWarnings({"NullableProblems", "unchecked"})
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int posIt = 0;

            @Override
            public boolean hasNext() {
                return posIt < pos;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) objects[posIt++];
            }
        };
    }
}
