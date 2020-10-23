package ru.job4j.board;

public interface BoardGame {

    void gamePrepare();

    void gameStart();

    boolean isFinish();

    void doTurn();
}
