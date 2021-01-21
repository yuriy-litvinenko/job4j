package ru.job4j.threads;

import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SingleLockListTest {
    @Test
    public void add() throws InterruptedException {
        SingleLockList<Integer> list = new SingleLockList<>(10);
        Thread first = new Thread(() -> list.add(1));
        Thread second = new Thread(() -> list.add(2));
        first.start();
        second.start();
        first.join();
        second.join();
        Set<Integer> rsl = new TreeSet<>();
        list.iterator().forEachRemaining(rsl::add);
        assertThat(rsl, is(Set.of(1, 2)));
    }
}
