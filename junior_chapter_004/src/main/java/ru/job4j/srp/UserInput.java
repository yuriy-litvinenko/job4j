package ru.job4j.srp;

import java.util.Scanner;

class UserInput {
    private Scanner sc = new Scanner(System.in);

    double getValue() {
        System.out.println("Enter value:");
        while (!sc.hasNextDouble()) {
            System.out.println("Enter correct value:");
            sc.next();
        }
        return sc.nextDouble();
    }

    String getOper(String[] actions) {
        String key;
        boolean exist = false;
        do {
            key = sc.next();
            for (String value : actions) {
                if (value.equals(key)) {
                    exist = true;
                    break;
                }
            }
            if (!exist) {
                System.out.println("Enter correct operator:");
            }
        } while (!exist);
        return key;
    }

    String getExit() {
        System.out.println("Exit calculation? (y - yes, any key - no):");
        return sc.next();
    }
}
