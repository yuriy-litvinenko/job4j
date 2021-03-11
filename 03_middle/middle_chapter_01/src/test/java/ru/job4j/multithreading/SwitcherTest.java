package ru.job4j.multithreading;

        import org.junit.Test;

public class SwitcherTest {

    @Test
    public void startTwoThreadsWithSwitcher() {
        Switcher switcher = new Switcher();
        Thread first = new Thread(
                () -> {
                    while (true) {
                        switcher.tryMaster();
                    }
                }
        );
        Thread second = new Thread(
                () -> {
                    while (true) {
                        switcher.trySlave();
                    }
                }
        );
        first.start();
        second.start();
    }
}
