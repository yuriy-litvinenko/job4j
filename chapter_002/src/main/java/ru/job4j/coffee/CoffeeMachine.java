package ru.job4j.coffee;

public class CoffeeMachine {

    public int[] changes(int value, int price) {
        int change = value - price;
        int[] coins = {10, 5, 2, 1};
        int coinsCnt = 0;
        int[] result = new int[coinsCnt];
        for (int coin : coins) {
            while (change >= coin) {
                change -= coin;
                coinsCnt++;
                int[] arrTmp = new int[coinsCnt];
                System.arraycopy(result, 0, arrTmp, 0, result.length);
                arrTmp[arrTmp.length - 1] = coin;
                result = arrTmp;
            }
        }
        return result;
    }
}
