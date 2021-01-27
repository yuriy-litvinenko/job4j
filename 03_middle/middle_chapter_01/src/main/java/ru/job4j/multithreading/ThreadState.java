package ru.job4j.multithreading;

public class ThreadState {
    public static void main(String[] args) {
        Thread first = new Thread(
                () -> {
                    try {
                        Thread.sleep(15);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );
        Thread second = new Thread(
                () -> {
                    try {
                        Thread.sleep(15);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );
        printStatus(first);
        printStatus(second);
        first.start();
        second.start();
        while (first.getState() != Thread.State.TERMINATED || second.getState() != Thread.State.TERMINATED) {
            printStatus(first);
            printStatus(second);
        }
        printStatus(first);
        printStatus(second);
        System.out.println("All multithreading are terminated");
    }

    private static void printStatus(Thread thread) {
        System.out.println(thread.getName() + ' ' + thread.getState());
    }
}
