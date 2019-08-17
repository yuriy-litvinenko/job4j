package ru.job4j.srp;

import java.util.*;

class MenuCalc {
    private Map<String, ActionCalc> actions = new LinkedHashMap<>();
    private static UserInput input;

    MenuCalc(UserInput input) {
        MenuCalc.input = input;
        this.fillActions();
    }

    String[] getActionsKeys() {
        return actions.keySet().toArray(new String[0]);
    }

    private void fillActions() {
        this.actions.put("+", new MenuCalc.AddAct("+", "Add"));
        this.actions.put("-", new MenuCalc.SubtractAct("-", "Subtrack"));
        this.actions.put("*", new MenuCalc.MultipleAct("*", "Multiple"));
        this.actions.put("/", new MenuCalc.DivisionAct("/", "Division"));
    }

    double select(String key, double value) {
        return this.actions.get(key).execute(value);
    }

    void show() {
        System.out.println("Enter operator:");
        for (ActionCalc action : this.actions.values()) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    private static class AddAct extends BaseCalcAction {
        AddAct(String key, String name) {
            super(key, name);
        }

        @Override
        public double execute(double value) {
            double valueSec = input.getValue();
            double result = Calculator.add(value, valueSec);
            System.out.println("Result: " + result);
            return result;
        }
    }

    private static class SubtractAct extends BaseCalcAction {
        SubtractAct(String key, String name) {
            super(key, name);
        }

        @Override
        public double execute(double value) {
            double valueSec = input.getValue();
            double result = Calculator.subtrack(value, valueSec);
            System.out.println("Result: " + result);
            return result;
        }
    }

    private static class MultipleAct extends BaseCalcAction {
        MultipleAct(String key, String name) {
            super(key, name);
        }

        @Override
        public double execute(double value) {
            double valueSec = input.getValue();
            double result = Calculator.multiply(value, valueSec);
            System.out.println("Result: " + result);
            return result;
        }
    }

    private static class DivisionAct extends BaseCalcAction {
        DivisionAct(String key, String name) {
            super(key, name);
        }

        @Override
        public double execute(double value) {
            double valueSec = input.getValue();
            double result = Calculator.div(value, valueSec);
            System.out.println("Result: " + result);
            return result;
        }
    }
}
