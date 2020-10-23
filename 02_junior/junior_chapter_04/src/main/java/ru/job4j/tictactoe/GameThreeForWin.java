package ru.job4j.tictactoe;

import java.util.Arrays;

public class GameThreeForWin extends GameLogic {

    GameThreeForWin(UserInput input) {
        super(input);
    }

    @Override
    void createTable() {
        int size = input.ask("Input table size (3 - 10): ", 3, 10);
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
                if (i + 2 < table.length
                        && table[i][j] == symbol
                        && table[i + 1][j] == symbol
                        && table[i + 2][j] == symbol) {
                    result = true;
                    break;
                }
                if (j + 2 < table.length
                        && table[i][j] == symbol
                        && table[i][j + 1] == symbol
                        && table[i][j + 2] == symbol) {
                    result = true;
                    break;
                }
                if (i + 2 < table.length
                        && j + 2 < table.length
                        && table[i][j] == symbol
                        && table[i + 1][j + 1] == symbol
                        && table[i + 2][j + 2] == symbol) {
                    result = true;
                    break;
                }
                if (i + 2 < table.length
                        && j + 2 < table.length
                        && table[i + 2][j] == symbol
                        && table[i + 1][j + 1] == symbol
                        && table[i][j + 2] == symbol) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}
