package ru.job4j.multithreading;

import org.junit.Test;

public class EmailNotificationTest {

    @Test
    public void sendEmailNotificationWithExecutorService() {
        EmailNotification emailNotification = new EmailNotification();
        UserNotification user = new UserNotification("User", "user@mail.ru");
        for (int i = 1; i <= 20; i++) {
            emailNotification.emailTo(user);
        }
        emailNotification.close();
    }
}
