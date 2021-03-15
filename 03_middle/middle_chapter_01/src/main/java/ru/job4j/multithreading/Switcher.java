package ru.job4j.multithreading;

public class Switcher {
    private boolean statusMaster = false;
    private boolean statusSlave = true;

    synchronized public void tryMaster() {
        if (!statusSlave) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread A");
        doneMaster();
        notifyAll();
    }

    synchronized public void trySlave() {
        if (!statusMaster) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread B");
        doneSlave();
        notifyAll();
    }

    private void doneMaster() {
        statusMaster = true;
        statusSlave = false;
    }

    private void doneSlave() {
        statusSlave = true;
        statusMaster = false;
    }
}
