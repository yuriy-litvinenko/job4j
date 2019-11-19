package ru.job4j.tictactoe;

import javafx.util.Pair;
import java.util.List;

class UserLogic extends PlayerLogic {

    UserLogic(UserInput input, GameLogic game) {
        super(input, game);
    }

    @Override
    void doTurn() {
        List<Pair<Integer, Integer>> emptyFields = game.getEmptyFields();
        boolean checkComplete = false;
        while (!checkComplete) {
            int x = input.ask("Input number of column: ", game.getTable().length);
            int y = input.ask("Input number of row: ", game.getTable().length);
            Pair<Integer, Integer> value = new Pair<>(x, y);
            if (emptyFields.contains(value)) {
                game.setValue(value, getSymbol());
                game.setUserOrder(false);
                checkComplete = true;
            } else {
                System.out.println("This field is already fill. Input correct coords.");
                checkComplete = false;
            }
        }
    }
}
