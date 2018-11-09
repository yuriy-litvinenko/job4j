package ru.job4j.coffee;

public class CoffeeMachine {

    public int[] changes(int value, int price) {
        int change = value - price;
        int[] coins = {10, 5, 2, 1};
        int[] buffer = new int[change];
        int coinsCnt = 0;
        for (int coin : coins) {
            while (change >= coin) {
                change -= coin;
                buffer[coinsCnt++] = coin;
            }
        }
        int[] result = new int[coinsCnt];
        System.arraycopy(buffer, 0, result, 0, result.length);
        return result;
    }
}
