package ru.job4j.multithreading;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CASCountTest {

    @Test
    public void incrementCountInThreeThreadsAndGetExpectedResult() throws InterruptedException {
        CASCount casCount = new CASCount();
        int numLoop = 3;
        Runnable runnable = () -> IntStream.range(0, numLoop).forEach(i -> casCount.increment());
        Thread first = new Thread(runnable);
        Thread second = new Thread(runnable);
        Thread third = new Thread(runnable);
        first.start();
        second.start();
        third.start();
        first.join();
        second.join();
        third.join();
        assertThat(casCount.get(), is(numLoop * 3));
    }
}
