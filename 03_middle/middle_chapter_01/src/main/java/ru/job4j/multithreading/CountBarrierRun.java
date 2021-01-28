package ru.job4j.multithreading;

public class CountBarrierRun {
    public static void main(String[] args) {
        CountBarrier countBarrier = new CountBarrier(5);
        Thread master = new Thread(
                () -> {
                    System.out.println(Thread.currentThread().getName() + " started");
                    for (int i = 1; i <= 10; i++) {
                        countBarrier.count();
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                },
                "Master"
        );
        Thread slave = new Thread(
                () -> {
                    countBarrier.await();
                    System.out.println(Thread.currentThread().getName() + " started");
                },
                "Slave"
        );
        Thread third = new Thread(
                () -> {
                    countBarrier.await();
                    System.out.println(Thread.currentThread().getName() + " started");
                },
                "Third"
        );
        master.start();
        slave.start();
        third.start();
    }
}
