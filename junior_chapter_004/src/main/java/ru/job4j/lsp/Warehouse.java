package ru.job4j.lsp;

class Warehouse extends Store {
    Warehouse(int size) {
        super(size);
    }

    @Override
    boolean accept(Food food) {
        boolean result = false;
        double prodTime = this.getProdTime(food.getCreateDate(), food.getExpireDate());
        if (prodTime < 25) {
            result = true;
        }
        return result;
    }
}
