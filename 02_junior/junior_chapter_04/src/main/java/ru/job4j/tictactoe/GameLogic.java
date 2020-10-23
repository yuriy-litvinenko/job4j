package ru.job4j.tictactoe;

import javafx.util.Pair;
import java.util.ArrayList;
import java.util.List;

abstract class GameLogic {
    UserInput input;
    char[][] table;
    private boolean userOrder;

    GameLogic(UserInput input) {
        this.input = input;
    }

    abstract void createTable();

    abstract boolean checkWin(char symbol);

    void printTable() {
        System.out.print("   ");
        for (int k = 0; k < table.length; k++) {
            System.out.print(k + " ");
        }
        System.out.println();
        for (int i = 0; i < table.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < table[i].length; j++) {
                System.out.print("|" + table[i][j]);
            }
            System.out.println("|");
        }
    }

    void setUserOrder(boolean userOrder) {
        this.userOrder = userOrder;
    }

    boolean getUserOrder() {
        return userOrder;
    }

    boolean isFull() {
        boolean result = true;
        for (char[] row : table) {
            for (char field : row) {
                if (field == ' ') {
                    result = false;
                    break;
                }
            }
        }
        if (result) {
            System.out.println("Game over!");
        }
        return result;
    }

    List<Pair<Integer, Integer>> getEmptyFields() {
        List<Pair<Integer, Integer>> emptyFields = new ArrayList<>();
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (table[i][j] == ' ') {
                    emptyFields.add(new Pair<>(i, j));
                }
            }
        }
        return emptyFields;
    }

    void setValue(Pair<Integer, Integer> value, char symbol) {
        int x = value.getKey();
        int y = value.getValue();
        table[x][y] = symbol;
    }

    char[][] getTable() {
        return table;
    }
}
