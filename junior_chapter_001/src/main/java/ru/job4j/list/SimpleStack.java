package ru.job4j.list;

import java.util.NoSuchElementException;

public class SimpleStack<T> {
    private int size;
    private Node<T> first;

    public int getSize() {
        return size;
    }

    public T poll() {
        if (size > 0) {
            Node<T> pollLink = this.first;
            this.first = this.first.next;
            this.size--;
            return pollLink.date;
        }
        throw new NoSuchElementException();
    }

    public void push(T value) {
        Node<T> newLink = new Node<>(value);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }

    private static class Node<T> {
        T date;
        Node<T> next;

        Node(T date) {
            this.date = date;
        }
    }
}
