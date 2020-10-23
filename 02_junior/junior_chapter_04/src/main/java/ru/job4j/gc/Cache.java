package ru.job4j.gc;

public interface Cache<K, V> {
    void put(K key);
    V get(K key);
}
