package ru.job4j.isp;

import java.util.List;

public class StartTaskUI {

    private MenuTask menu = new MenuTask();
    private UserInput input = new UserInput();

    public static void main(String[] args) {
        new StartTaskUI().start();
    }

    private void start() {
        createMenu();
        List<MenuItem> menuItems = menu.getMenuItemList();
        List<String> ranges = menu.getActionList();
        String key;
        do {
            menu.showMenuItems(menuItems);
            key = input.ask("Input task number: ", ranges);
            menu.getMenuItem(key, menuItems).execute();
        } while (!"y".equals(input.ask("Exit(y)?: ")));
    }

    private void createMenu() {
        MenuItem task1 = menu.addMenuItem("1", "Task 1");
        MenuItem task11 = menu.addChildMenuItem("1.1", "Task 1.1", task1);
        MenuItem task12 = menu.addChildMenuItem("1.2", "Task 1.2", task1);
        MenuItem task121 = menu.addChildMenuItem("1.2.1", "Task 1.2.1", task12);
        MenuItem task122 = menu.addChildMenuItem("1.2.2", "Task 1.2.2", task12);
        MenuItem task13 = menu.addChildMenuItem("1.3", "Task 1.3", task1);
        MenuItem task2 = menu.addMenuItem("2", "Task 2");
        MenuItem task21 = menu.addChildMenuItem("2.1", "Task 2.1", task2);
        MenuItem task22 = menu.addChildMenuItem("2.2", "Task 2.2", task2);
        task22.setAction(new UserActionList.TestAction());
    }
}
