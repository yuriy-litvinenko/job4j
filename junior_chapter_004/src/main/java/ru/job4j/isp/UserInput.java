package ru.job4j.isp;

import java.util.List;
import java.util.Scanner;

class UserInput {

    private Scanner scanner = new Scanner(System.in);

    String ask(String question) {
        System.out.print(question);
        return scanner.next();
    }

    String ask(String question, List<String> range) {
        String key;
        boolean exist = false;
        do {
            key = this.ask(question);
            for (String value : range) {
                if (value.equals(key)) {
                    exist = true;
                    break;
                }
            }
            if (!exist) {
                System.out.println("Out of menu range. Input correct value.");
            }
        } while (!exist);
        return key;
    }
}
