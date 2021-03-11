package ru.job4j.multithreading;

import org.junit.Test;

public class ThreadPoolTest {

    @Test
    public void completeMultipleJobsInTheThreadsAndViewResults() throws InterruptedException {
        ThreadPool threadPool = new ThreadPool();
        Runnable job = () -> {
        };
        for (int i = 0; i <= 20; i++) {
            threadPool.work(job);
        }
        threadPool.shutdown();
    }
}
