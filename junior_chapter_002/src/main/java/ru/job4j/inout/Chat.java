package ru.job4j.inout;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Chat {
    private List<String> answers = getAnswersList();

    public static void main(String[] args) {
        Chat chat = new Chat();
        chat.run();
    }

    private void run() {
        Scanner in = new Scanner(System.in);
        boolean botOn = true;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("junior_chapter_002\\target\\chat.log"))) {
            String command;
            do {
                if (botOn) {
                    writer.write("Программа: " + getAnswer() + "\n");
                }
                System.out.print("Пользователь: ");
                command = in.nextLine();
                writer.write("Пользователь: " + command + "\n");
                if (command.equals("stop")) {
                    botOn = false;
                }
                if (command.equals("continue")) {
                    botOn = true;
                }
            } while (!command.equals("exit"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<String> getAnswersList() {
        List<String> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Chat.class.getResourceAsStream("/bot.txt")))) {
            String str;
            while ((str = reader.readLine()) != null) {
                result.add(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private String getAnswer() {
        Random random = new Random();
        String result = answers.get(random.nextInt(answers.size()));
        System.out.println("Программа: " + result);
        return result;
    }
}
