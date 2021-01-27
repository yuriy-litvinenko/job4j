package ru.job4j.multithreading;

public class ConsoleProgress implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        Thread progress = new Thread(new ConsoleProgress());
        progress.start();
        Thread.sleep(4000);
        progress.interrupt();
    }

    @Override
    public void run() {
        char ch = '-';
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                break;
            }
            if (ch == '-') {
                ch = '\\';
            } else if (ch == '\\') {
                ch = '|';
            } else if (ch == '|') {
                ch = '/';
            } else {
                ch = '-';
            }
            System.out.print("\rLoading : " + ch);
        }
    }
}
