package ru.job4j.tictactoe;

abstract class PlayerLogic {
    private char symbol;
    UserInput input;
    GameLogic game;

    PlayerLogic(UserInput input, GameLogic game) {
        this.input = input;
        this.game = game;
    }

    abstract void doTurn();

    void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    char getSymbol() {
        return symbol;
    }
}
