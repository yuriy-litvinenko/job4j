package ru.job4j.multithreading;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

@ThreadSafe
class SimpleBlockingQueue<T> {
    @GuardedBy("this")
    private final Queue<T> queue = new LinkedList<>();
    private int total = 2;

    public void offer(T value) throws InterruptedException {
        synchronized (this) {
            while (queue.size() == total) {
                wait();
            }
            queue.add(value);
            notifyAll();
        }
    }

    public T poll() throws InterruptedException {
        synchronized (this) {
            T obj;
            while (queue.size() == 0) {
                wait();
            }
            obj = queue.poll();
            notifyAll();
            return obj;
        }
    }

    public synchronized boolean isEmpty() {
        return queue.size() == 0;
    }
}
