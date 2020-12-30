package ru.job4j.threads;

import net.jcip.annotations.ThreadSafe;
import ru.job4j.generic.SimpleArray;

import java.util.Iterator;

@ThreadSafe
public class SingleLockList<T> implements Iterable<T> {
    private final SimpleArray<T> array;

    SingleLockList(int size) {
        this.array = new SimpleArray<>(size);
    }

    synchronized void add(T value) {
        array.add(value);
    }

    T get(int index) {
        return array.get(index);
    }

    @Override
    @SuppressWarnings("NullableProblems")
    public synchronized Iterator<T> iterator() {
        return copy(this.array).iterator();
    }

    private SimpleArray<T> copy(SimpleArray<T> array) {
        SimpleArray<T> copyArray = new SimpleArray<>(array.length());
        for (int i = 0; i <= array.length(); i++) {
            copyArray.add(array.get(i));
        }
        return copyArray;
    }
}
