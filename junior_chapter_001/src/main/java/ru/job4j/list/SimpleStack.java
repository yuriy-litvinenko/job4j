package ru.job4j.list;

import java.util.NoSuchElementException;

public class SimpleStack<T> {
    private SimpleLinkedList<T> container = new SimpleLinkedList<>();
    private int pos;

    public int getSize() {
        return pos;
    }

    public T poll() {
        if (pos > 0) {
            return container.remove(pos-- - 1);
        }
        throw new NoSuchElementException();
    }

    public void push(T value) {
        container.add(value);
        pos++;
    }
}