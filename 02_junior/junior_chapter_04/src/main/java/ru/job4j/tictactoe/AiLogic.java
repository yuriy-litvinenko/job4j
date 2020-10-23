package ru.job4j.tictactoe;

import javafx.util.Pair;
import java.util.List;
import java.util.Random;

class AiLogic extends PlayerLogic {

    AiLogic(UserInput input, GameLogic game) {
        super(input, game);
    }

    @Override
    void doTurn() {
        Random random = new Random();
        List<Pair<Integer, Integer>> emptyFields = game.getEmptyFields();
        Pair<Integer, Integer> emptyField = emptyFields.get(random.nextInt(emptyFields.size()));
        game.setValue(emptyField, getSymbol());
        game.setUserOrder(true);
    }
}
