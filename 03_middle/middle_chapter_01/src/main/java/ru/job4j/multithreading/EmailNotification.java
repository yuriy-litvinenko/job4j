package ru.job4j.multithreading;

        import java.util.concurrent.ExecutorService;
        import java.util.concurrent.Executors;

public class EmailNotification {
    private final ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public void emailTo(UserNotification user) {
        String subject = "Notification " + user.getUsername() + " to email " + user.getEmail();
        String body = "Add a new event to " + user.getUsername();
        pool.submit(() -> {
            send(subject, body, user.getEmail());
            System.out.println("Execute " + Thread.currentThread().getName());
        });
    }

    public void close() {
        pool.shutdown();
        while (!pool.isTerminated()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Pool shutdown");
    }

    private void send(String subject, String body, String email) {

    }
}
