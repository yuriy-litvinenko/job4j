package ru.job4j.srp;

class MenuCalcEng extends MenuCalc {

    MenuCalcEng(UserInput input) {
        super(input);
    }

    void fillActions() {
        super.fillActions();
        this.actions.put("sin", new MenuCalcEng.SineAct("sin", "Sine"));
        this.actions.put("cos", new MenuCalcEng.CosineAct("cos", "Cosine"));
        this.actions.put("tg", new MenuCalcEng.TangentAct("tg", "Tangent"));
        this.actions.put("ctg", new MenuCalcEng.CotangentAct("ctg", "Cotangent"));
        this.actions.put("clr", new MenuCalcEng.ClearResultAct("clr", "Clear result"));
    }

    static class SineAct extends BaseCalcAction {
        SineAct(String key, String name) {
            super(key, name);
        }

        @Override
        public double execute(double value) {
            double result = CalculatorEng.sin(value);
            System.out.println("Result Sine of " + value + ": " + result);
            return result;
        }
    }

    static class CosineAct extends BaseCalcAction {
        CosineAct(String key, String name) {
            super(key, name);
        }

        @Override
        public double execute(double value) {
            double result = CalculatorEng.cos(value);
            System.out.println("Result Cosine of " + value + ": " + result);
            return result;
        }
    }

    static class TangentAct extends BaseCalcAction {
        TangentAct(String key, String name) {
            super(key, name);
        }

        @Override
        public double execute(double value) {
            double result = CalculatorEng.tg(value);
            System.out.println("Result Tangent of " + value + ": " + result);
            return result;
        }
    }

    static class CotangentAct extends BaseCalcAction {
        CotangentAct(String key, String name) {
            super(key, name);
        }

        @Override
        public double execute(double value) {
            double result = CalculatorEng.ctg(value);
            System.out.println("Result Cotangent of " + value + ": " + result);
            return result;
        }
    }

    static class ClearResultAct extends BaseCalcAction {
        ClearResultAct(String key, String name) {
            super(key, name);
        }

        @Override
        public double execute(double value) {
            return input.getValue();
        }
    }
}
