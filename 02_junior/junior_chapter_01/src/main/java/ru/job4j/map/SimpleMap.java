package ru.job4j.map;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleMap<K, V> implements Iterable {
    @SuppressWarnings("unchecked")
    private Entry<K, V>[] entries = new Entry[16];
    private int pos;

    boolean insert(K key, V value) {
        boolean result = false;
        int index = getIndex(key.hashCode(), entries.length);
        if (entries[index] == null) {
            checkLength();
            entries[index] = new Entry<>(key, value);
            pos++;
            result = true;
        }
        return result;
    }

    V get(K key) {
        Entry<K, V> result = entries[getIndex(key.hashCode(), entries.length)];
        return result != null ? result.value : null;
    }

    boolean delete(K key) {
        boolean result = false;
        int index = getIndex(key.hashCode(), entries.length);
        if (entries[index] != null) {
            entries[index] = null;
            pos--;
            result = true;
        }
        return result;
    }

    private int getIndex(int hashcode, int lengthArr) {
        hashcode ^= (hashcode >>> 20) ^ (hashcode >>> 12);
        int hash = hashcode ^ (hashcode >>> 7) ^ (hashcode >>> 4);
        return hash & (lengthArr - 1);
    }

    private void checkLength() {
        if (pos == entries.length * .75) {
            entries = Arrays.copyOf(entries, entries.length * 2);
        }
    }

    @Override
    @SuppressWarnings("NullableProblems")
    public Iterator<Entry<K, V>> iterator() {
        return new Iterator<>() {
            int posIt;

            @Override
            public boolean hasNext() {
                boolean result = false;
                while (posIt < entries.length) {
                    if (entries[posIt] != null) {
                        result = true;
                        break;
                    }
                    posIt++;
                }
                return result;
            }

            @Override
            public Entry<K, V> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return entries[posIt++];
            }
        };
    }

    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
