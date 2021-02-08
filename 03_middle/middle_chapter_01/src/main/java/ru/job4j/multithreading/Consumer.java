package ru.job4j.multithreading;

import java.util.ArrayList;
import java.util.List;

public class Consumer<T> implements Runnable {
    private final SimpleBlockingQueue<T> sbQueue;
    private List<T> listDownload = new ArrayList<>();

    public Consumer(SimpleBlockingQueue<T> sbQueue) {
        this.sbQueue = sbQueue;
    }

    private void get() throws InterruptedException {
        T obj;
        obj = sbQueue.poll();
        if (obj != null) {
            listDownload.add(obj);
            System.out.println("Get value: " + obj);
        }
    }

    public List<T> getList() {
        return listDownload;
    }

    @Override
    public void run() {
        System.out.println("Consumer thread start");
        while (!sbQueue.isEmpty()) {
            try {
                get();
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Consumer thread done");
    }
}
