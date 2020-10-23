package ru.job4j.tictactoe;

class TicTacToe {
    private GameLogic game;
    private UserLogic user;
    private AiLogic ai;
    private UserInput input = new UserInput();

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.startGame();
    }

    private void startGame() {
        this.setGameMode();
        user = new UserLogic(input, game);
        ai = new AiLogic(input, game);
        this.setFirstPlayer();
        game.createTable();
        System.out.println("Start new game");
        if (game.getUserOrder()) {
            game.printTable();
        }
        while (!game.isFull()) {
            if (game.getUserOrder()) {
                System.out.println("Your move");
                user.doTurn();
                game.printTable();
                if (game.checkWin(user.getSymbol())) {
                    System.out.println("You win!");
                    break;
                }
            } else {
                System.out.println("AI move");
                ai.doTurn();
                game.printTable();
                if (game.checkWin(ai.getSymbol())) {
                    System.out.println("AI win!");
                    break;
                }
            }
        }
    }

    private void setGameMode() {
        int rule = input.ask("Select difficult of game (1 - Three for win, 2 - Five for win): ", new int[]{1, 2});
        if (rule == 1) {
            game = new GameThreeForWin(input);
        } else {
            game = new GameFiveForWin(input);
        }
    }

    private void setFirstPlayer() {
        int order = input.ask("Input your game order (1, 2): ", new int[]{1, 2});
        if (order == 1) {
            user.setSymbol('X');
            ai.setSymbol('O');
            game.setUserOrder(true);
        } else {
            user.setSymbol('O');
            ai.setSymbol('X');
            game.setUserOrder(false);
        }
    }
}
