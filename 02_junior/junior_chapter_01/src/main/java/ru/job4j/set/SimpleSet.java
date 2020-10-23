package ru.job4j.set;

import ru.job4j.list.SimpleList;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<E> implements Iterable {

    private SimpleList<E> simpleList = new SimpleList<>();

    private boolean isAvailable(E value) {
        for (E checkVal : simpleList) {
            if (Objects.equals(checkVal, value)) {
                return true;
            }
        }
        return false;
    }

    public void add(E value) {
        if (!isAvailable(value)) {
            simpleList.add(value);
        }
    }

    public E get(int index) {
        return simpleList.get(index);
    }

    @Override
    @SuppressWarnings("NullableProblems")
    public Iterator iterator() {
        return simpleList.iterator();
    }
}
