package ru.job4j.lsp;

class WarehouseLowTemp extends Store {

    WarehouseLowTemp(int size) {
        super(size);
    }

    @Override
    boolean accept(Food food) {
        boolean result = false;
        if (food instanceof Vegetable) {
            double prodTime = this.getProdTime(food.getCreateDate(), food.getExpireDate());
            if (prodTime < 25) {
                result = true;
            }
        }
        return result;
    }
}
