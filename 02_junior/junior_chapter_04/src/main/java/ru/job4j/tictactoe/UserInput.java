package ru.job4j.tictactoe;

import java.util.Scanner;

class UserInput {

    private Scanner scanner = new Scanner(System.in);

    private int ask(String question) {
        System.out.print(question);
        return scanner.nextInt();
    }

    int ask(String question, int[] range) {
        int key;
        boolean exist = false;
        do {
            key = this.ask(question);
            for (int value : range) {
                if (value == key) {
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

    int ask(String question, int min, int max) {
        int key;
        boolean exist = false;
        do {
            key = this.ask(question);
            for (int value = min; value <= max; value++) {
                if (value == key) {
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

    int ask(String question, int range) {
        int key;
        boolean exist = false;
        do {
            key = this.ask(question);
            if (key < range) {
                exist = true;
            }
            if (!exist) {
                System.out.println("Out of menu range. Input correct value.");
            }
        } while (!exist);
        return key;
    }
}
