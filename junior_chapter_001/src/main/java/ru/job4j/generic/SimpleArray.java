package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable {
    private Object[] objects;
    private int pos = 0;

    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    public void add(T model) {
        if (pos < objects.length) {
            objects[pos++] = model;
        }
    }

    public void set(int index, T model) {
        if (index < pos) {
            objects[index] = model;
        }
    }

    public void remove(int index) {
        if (index < objects.length) {
            System.arraycopy(objects, index + 1, objects, index, objects.length - 1 - index);
            pos--;
        }
    }

    public T get(int index) {
        if (index < objects.length) {
            return (T) objects[index];
        }
        return null;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private int posIt = 0;

            @Override
            public boolean hasNext() {
                return posIt < objects.length && objects[posIt] != null;
            }

            @Override
            public Object next() {
                if (posIt < objects.length && objects[posIt] != null) {
                    return objects[posIt++];
                }
                throw new NoSuchElementException();
            }
        };
    }
}
