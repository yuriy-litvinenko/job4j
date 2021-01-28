package ru.job4j.multithreading;

class CountBarrier {
    private final Object monitor = this;

    private final int total;

    private int count = 0;

    CountBarrier(final int total) {
        this.total = total;
    }

    void count() {
        synchronized (monitor) {
            count++;
            System.out.println("Значение счетчика = " + count);
            monitor.notifyAll();
        }
    }

    void await() {
        synchronized (monitor) {
            while (count != total) {
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
