package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListContainer<E> implements Iterable<E> {

    private Node<E> firstNode;
    private Node<E> lastNode;
    private int size = 0;
    private int modCount = 0;

    public void add(E value) {
        Node<E> newNode = new Node(value, lastNode, null);
        if (size == 0) {
            firstNode = newNode;
            lastNode = newNode;
        }
        lastNode.next = newNode;
        lastNode = newNode;
        size++;
        modCount++;
    }

    public E get(int index) {
        if (index < size) {
            Node<E> resultNode = firstNode;
            for (int i = 0; i < index; i++) {
                resultNode = resultNode.next;
            }
            return resultNode.value;
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
                return posIt < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return get(posIt++);
            }
        };
    }

    private static class Node<E> {
        E value;
        Node next;
        Node prev;

        Node(E date, Node prev, Node next) {
            this.value = date;
            this.prev = prev;
            this.next = next;
        }
    }
}
