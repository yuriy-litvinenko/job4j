package ru.job4j.multithreading;

public class ParallelSearch {

    public static void main(String[] args) {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>();
        final Thread consumer = new Thread(
                () -> {
                    boolean available = true;
                    while (available) {
                        try {
                            System.out.println(queue.poll());
                        } catch (InterruptedException e) {
                            available = false;
                            e.printStackTrace();
                            Thread.currentThread().interrupt();
                        }

                    }

                }
        );
        consumer.start();
        new Thread(
                () -> {
                    for (int index = 0; index != 3; index++) {
                        try {
                            queue.offer(index);
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    consumer.interrupt();
                }
        ).start();
    }
}
