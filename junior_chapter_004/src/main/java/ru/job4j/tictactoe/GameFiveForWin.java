package ru.job4j.tictactoe;

import java.util.Arrays;

public class GameFiveForWin extends GameLogic {

    GameFiveForWin(UserInput input) {
        super(input);
    }

    @Override
    void createTable() {
        int size = input.ask("Input table size (5 - 15): ", 5, 15);
        table = new char[size][size];
        for (char[] row : table) {
            Arrays.fill(row, ' ');
        }
    }

    @Override
    public boolean checkWin(char symbol) {
        boolean result = false;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (i + 4 < table.length
                        && table[i][j] == symbol
                        && table[i + 1][j] == symbol
                        && table[i + 2][j] == symbol
                        && table[i + 3][j] == symbol
                        && table[i + 4][j] == symbol) {
                    result = true;
                    break;
                }
                if (j + 4 < table.length
                        && table[i][j] == symbol
                        && table[i][j + 1] == symbol
                        && table[i][j + 2] == symbol
                        && table[i][j + 3] == symbol
                        && table[i][j + 4] == symbol) {
                    result = true;
                    break;
                }
                if (i + 4 < table.length
                        && j + 4 < table.length
                        && table[i][j] == symbol
                        && table[i + 1][j + 1] == symbol
                        && table[i + 2][j + 2] == symbol
                        && table[i + 3][j + 3] == symbol
                        && table[i + 4][j + 4] == symbol) {
                    result = true;
                    break;
                }
                if (i + 4 < table.length
                        && j + 4 < table.length
                        && table[i + 4][j] == symbol
                        && table[i + 3][j + 1] == symbol
                        && table[i + 2][j + 2] == symbol
                        && table[i + 1][j + 3] == symbol
                        && table[i][j + 4] == symbol) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}
