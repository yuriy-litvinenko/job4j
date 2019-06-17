package ru.job4j.tracker;

import java.util.function.Consumer;

public class StartUI {

    private final Input input;
    private final ITracker tracker;
    private final Consumer<String> output;

    StartUI(Input input, ITracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker, output);
        menu.fillActions();
        do {
            menu.show();
            int[] ranges = menu.getActionsKeys();
            menu.select(input.ask("select: ", ranges));
        } while (!"y".equals(this.input.ask("Exit?(y): ")));
    }

    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker(), System.out::println).init();
    }
}
