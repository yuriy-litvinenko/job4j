package ru.job4j.srp;

public abstract class BaseCalcAction implements ActionCalc {
    private final String key;
    private final String name;

    BaseCalcAction(final String key, final String name) {
        this.key = key;
        this.name = name;
    }

    @Override
    public String info() {
        return String.format("%s : %s", this.key, this.name);
    }
}
