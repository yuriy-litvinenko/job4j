package ru.job4j.tree;

import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    private Node<E> root;

    Tree(E value) {
        this.root = new Node<>(value);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        Optional<Node<E>> parentNode = findBy(parent);
        Optional<Node<E>> childNode = findBy(child);
        if (parentNode.isPresent() && childNode.isEmpty()) {
            parentNode.get().add(new Node<>(child));
            result = true;
        }
        return result;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    @Override
    public Iterator<E> iterator() {
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(root);

        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return !data.isEmpty();
            }

            @Override
            public E next() {
                Node<E> el;
                if (hasNext()) {
                    el = data.poll();
                    if (el != null) {
                        for (Node<E> child : el.leaves()) {
                            data.offer(child);
                        }
                        return el.getValue();
                    }
                }
                throw new NoSuchElementException();
            }
        };
    }
}
