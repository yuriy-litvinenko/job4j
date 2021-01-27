package ru.job4j.multithreading;

import org.junit.Test;

public class UserStorageTest {

    @Test
    public void doConcurrentTransfersForTheSameUsers() {
        UserStorage storage = new UserStorage();
        storage.add(new User(1, 100));
        storage.add(new User(2, 200));
        Thread first = new Thread(
                () -> storage.transfer(1, 2, 50)
        );
        Thread second = new Thread(
                () -> storage.transfer(1, 2, 50)
        );
        Thread third = new Thread(
                () -> storage.transfer(1, 2, 50)
        );
        first.start();
        second.start();
        third.start();
        try {
            first.join();
            second.join();
            third.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
