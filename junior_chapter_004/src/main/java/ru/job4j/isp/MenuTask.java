package ru.job4j.isp;

import java.util.*;

class MenuTask {

    private List<MenuItem> menuParentList = new ArrayList<>();

    MenuItem addMenuItem(String key, String name) {
        MenuItem newMenuItem = new MenuItem(key, name);
        menuParentList.add(newMenuItem);
        return newMenuItem;
    }

    MenuItem addChildMenuItem(String key, String name, MenuItem parent) {
        MenuItem newMenuItem = new MenuItem(key, name, parent.getLevel() + 1);
        parent.addChild(newMenuItem);
        return newMenuItem;
    }

    List<MenuItem> getMenuItemList() {
        List<MenuItem> result = new ArrayList<>();
        Stack<MenuItem> stack1 = new Stack<>();
        Stack<MenuItem> stack2 = new Stack<>();
        stack2.addAll(menuParentList);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        while (!stack1.isEmpty()) {
            MenuItem addItem = stack1.pop();
            result.add(addItem);
            stack2.addAll(addItem.getChildList());
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }
        return result;
    }

    List<String> getActionList() {
        List<String> result = new ArrayList<>();
        Queue<MenuItem> queue = new LinkedList<>(menuParentList);
        while (!queue.isEmpty()) {
            MenuItem addItem = queue.poll();
            result.add(addItem.getKey());
            queue.addAll(addItem.getChildList());
        }
        return result;
    }

    void showMenuItems(List<MenuItem> menuItems) {
        for (MenuItem menuItem : menuItems) {
            System.out.println(menuItem);
        }
    }

    MenuItem getMenuItem(String key, List<MenuItem> menuItems) {
        MenuItem result = null;
        for (MenuItem menuItem : menuItems) {
            if (menuItem.getKey().equals(key)) {
                result = menuItem;
            }
        }
        return result;
    }
}
