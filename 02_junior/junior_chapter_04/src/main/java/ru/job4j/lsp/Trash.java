package ru.job4j.lsp;

class Trash extends Store {
    Trash(int size) {
        super(size);
    }

    @Override
    boolean accept(Food food) {
        boolean result = false;
        double prodTime = this.getProdTime(food.getCreateDate(), food.getExpireDate());
        if (prodTime >= 100) {
            result = true;
        }
        return result;
    }
}
