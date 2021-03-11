package ru.job4j.multithreading;

import java.util.LinkedList;
import java.util.List;

public class ThreadPool {
    private final List<Thread> threads = new LinkedList<>();
    private final SimpleBlockingQueue<Runnable> tasks = new SimpleBlockingQueue<>();
    private final int size;

    public ThreadPool() {
        size = Runtime.getRuntime().availableProcessors();
        for (int i = 1; i <= size; i++) {
            Thread newTask = new TaskThread("Thread " + i, tasks);
            threads.add(newTask);
            newTask.start();
        }
    }

    public void work(Runnable job) throws InterruptedException {
        tasks.offer(job);
    }

    public void shutdown() {
        System.out.println("Shutdown the threads");
        for (int i = 0; i < size; i++) {
            threads.get(i).interrupt();
        }
    }

    private class TaskThread extends Thread {
        private final SimpleBlockingQueue<Runnable> tasks;

        public TaskThread(String name, SimpleBlockingQueue<Runnable> tasks) {
            super();
            setName(name);
            this.tasks = tasks;
        }

        @Override
        public void run() {
            while (!isInterrupted()) {
                try {
                    tasks.poll().run();
                    System.out.println(currentThread().getName() + " completed the task");
                } catch (InterruptedException e) {
                    System.out.println(currentThread().getName() + " was interrupted");
                }
            }
            System.out.println(currentThread().getName() + " was ended");
        }
    }
}
