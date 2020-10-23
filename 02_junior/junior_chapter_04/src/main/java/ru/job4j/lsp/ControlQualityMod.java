package ru.job4j.lsp;

class ControlQualityMod {

    private ControlQuality controlQuality;

    ControlQualityMod(ControlQuality controlQuality) {
        this.controlQuality = controlQuality;
    }

    boolean putFood(Food food) {
        return controlQuality.putFood(food);
    }

    void addWarehouse(int size) {
        controlQuality.addWarehouse(size);
    }

    void addShop(int size) {
        controlQuality.addShop(size);
    }

    void addTrash(int size) {
        controlQuality.addTrash(size);
    }

    void addReproduce(int size) {
        controlQuality.getStorage().add(new Reproduce(size));
    }

    void addWarehouseLowTemp(int size) {
        controlQuality.getStorage().add(new WarehouseLowTemp(size));
    }
}
