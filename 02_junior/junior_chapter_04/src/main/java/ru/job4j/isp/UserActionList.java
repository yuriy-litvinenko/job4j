package ru.job4j.isp;

class UserActionList {

    static class TestAction implements UserAction {

        @Override
        public void execute() {
            System.out.println("Testing action");
        }
    }

    static class DefaultAction implements UserAction {

        @Override
        public void execute() {
            System.out.println("Action is not defined");
        }
    }
}
