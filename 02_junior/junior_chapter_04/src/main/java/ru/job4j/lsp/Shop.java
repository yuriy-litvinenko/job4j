package ru.job4j.lsp;

class Shop extends Store {
    Shop(int size) {
        super(size);
    }

    @Override
    boolean accept(Food food) {
        boolean result = false;
        double prodTime = this.getProdTime(food.getCreateDate(), food.getExpireDate());
        if (prodTime >= 25 && prodTime <= 75) {
            result = true;
        } else if (prodTime > 75 && prodTime < 100) {
            food.useDiscount();
            result = true;
        }
        return result;
    }
}
