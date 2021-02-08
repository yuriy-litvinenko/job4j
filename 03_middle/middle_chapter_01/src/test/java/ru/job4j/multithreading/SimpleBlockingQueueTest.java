package ru.job4j.multithreading;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SimpleBlockingQueueTest {
    @Test
    public void addValuesToProducerThreadAndGetThemInConsumerThread() throws InterruptedException {
        SimpleBlockingQueue<Integer> simpleBlockingQueue = new SimpleBlockingQueue<>();
        Producer<Integer> producer = new Producer<>(simpleBlockingQueue);
        Consumer<Integer> consumer = new Consumer<>(simpleBlockingQueue);
        Thread prodThread = new Thread(producer);
        Thread consThread = new Thread(consumer);
        producer.putList(Arrays.asList(1, 2, 3, 4, 5));
        prodThread.start();
        prodThread.join(4000);
        consThread.start();
        consThread.join();
        assertThat(consumer.getList(), is(Arrays.asList(1, 2, 3, 4, 5)));
    }
}
