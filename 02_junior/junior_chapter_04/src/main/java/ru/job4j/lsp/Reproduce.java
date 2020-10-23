package ru.job4j.lsp;

class Reproduce extends Store {

    Reproduce(int size) {
        super(size);
    }

    @Override
    boolean accept(Food food) {
        boolean result = false;
        if (food instanceof CanReproduce) {
            double prodTime = this.getProdTime(food.getCreateDate(), food.getExpireDate());
            if (prodTime >= 100) {
                result = true;
            }
        }
        return result;
    }
}
