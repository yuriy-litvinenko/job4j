package ru.job4j.list;

import java.util.NoSuchElementException;

class SimpleStack<T> {
    private SimpleLinkedList<T> container = new SimpleLinkedList<>();
    private int pos;

    int getSize() {
        return pos;
    }

    T poll() {
        if (pos > 0) {
            return container.remove(pos-- - 1);
        }
        throw new NoSuchElementException();
    }

    void push(T value) {
        container.add(value);
        pos++;
    }
}
