package ru.job4j.multithreading;

import java.util.List;

public class Producer<T> implements Runnable {
    private final SimpleBlockingQueue<T> sbQueue;
    private List<T> listUpload;

    public Producer(SimpleBlockingQueue<T> sbQueue) {
        this.sbQueue = sbQueue;
    }

    private void add(T obj) throws InterruptedException {
        sbQueue.offer(obj);
    }

    public void putList(List<T> list) {
        this.listUpload = list;
    }

    @Override
    public void run() {
        System.out.println("Producer thread start");
        for (T obj : listUpload) {
            try {
                add(obj);
                System.out.println("Add value: " + obj);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Producer thread done");
    }
}
