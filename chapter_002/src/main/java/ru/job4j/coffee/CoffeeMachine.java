package ru.job4j.coffee;

public class CoffeeMachine {

    public int[] changes(int value, int price) {
        int coin10, coin5, coin2, coin1;
        int change = value - price;
        coin10 = change / 10;
        coin5 = (change - coin10 * 10) / 5;
        coin2 = (change - coin10 * 10 - coin5 * 5) / 2;
        coin1 = change - coin10 * 10 - coin5 * 5 - coin2 * 2;
        int size = coin10 + coin5 + coin2 + coin1;
        int[] coins = new int[size];
        for (int index = 0; index <= coins.length; index++) {
            if (coin10-- > 0) {
                coins[index] = 10;
            } else if (coin5-- > 0) {
                coins[index] = 5;
            } else if (coin2-- > 0) {
                coins[index] = 2;
            } else if (coin1-- > 0) {
                coins[index] = 1;
            }
        }
        return coins;
    }
}
