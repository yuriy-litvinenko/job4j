package ru.job4j.multithreading;

public class ThreadSleep {
    public static void main(String[] args) {
        Thread thread = new Thread(
                () -> {
                    try {
                        for (int index = 0; index <= 100; index++) {
                            Thread.sleep(250);
                            System.out.print("\rLoading : " + index  + "%");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );
        thread.start();
    }
}
