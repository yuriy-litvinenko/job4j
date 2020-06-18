package ru.job4j.gc;

public class MemoryUsage {
    private static int mb = 1024 * 1024;
    private static Runtime runtime = Runtime.getRuntime();

    public static void main(String[] args) {
        //memOverflow();
        memInfo();
        for (int i = 0; i <= 5; i++) {
            User user = new User(3 * mb);
            memInfo();
        }
    }

    private static void memInfo() {
        System.out.println("Total: " + (runtime.totalMemory() / mb) + " Mb \t Free memory: " + (runtime.freeMemory() / mb) + " Mb");
    }

    private static void memOverflow() {
        User user1 = new User(3 * mb);
        memInfo();
        User user2 = new User(3 * mb);
        memInfo();
        User user3 = new User(3 * mb);
        memInfo();
        User user4 = new User(3 * mb);
        memInfo();
        User user5 = new User(3 * mb);
        memInfo();
    }
}
