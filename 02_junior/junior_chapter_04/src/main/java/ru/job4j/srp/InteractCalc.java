package ru.job4j.srp;

public class InteractCalc {

    public static void main(String[] args) {
        UserInput input = new UserInput();
        MenuCalc menuCalc = new MenuCalc(input);
        String[] actions = menuCalc.getActionsKeys();
        double value = input.getValue();
        do {
            menuCalc.show();
            value = menuCalc.select(input.getOper(actions), value);
        } while (!"y".equals(input.getExit()));
    }
}
