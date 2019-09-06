package ru.job4j.srp;

public class InteractCalcEng {

    public static void main(String[] args) {
        UserInput input = new UserInput();
        MenuCalcEng menuCalc = new MenuCalcEng(input);
        String[] actions = menuCalc.getActionsKeys();
        double value = input.getValue();
        do {
            menuCalc.show();
            value = menuCalc.select(input.getOper(actions), value);
        } while (!"y".equals(input.getExit()));
    }
}
