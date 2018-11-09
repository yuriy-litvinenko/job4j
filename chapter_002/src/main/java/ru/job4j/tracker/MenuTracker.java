package ru.job4j.tracker;

import java.util.List;

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[6];

    public int[] getActionsKeys() {
        int[] actionsKey = new int[actions.length];
        for (int index = 0; index < actions.length; index++) {
            actionsKey[index] = actions[index].key();
        }
        return actionsKey;
    }

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillActions() {
        this.actions[0] = new MenuTracker.AddItem(0, "Добавить новую заявку");
        this.actions[1] = new MenuTracker.ShowItems(1, "Показать все заявки");
        this.actions[2] = new MenuTracker.EditItem(2, "Редактировать заявку");
        this.actions[3] = new MenuTracker.DeleteItem(3, "Удалить заявку");
        this.actions[4] = new MenuTracker.FindItemById(4, "Найти заявку по идентификатору");
        this.actions[5] = new MenuTracker.FindItemByName(5, "Найти заявку по имени");
    }

    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    private static class AddItem extends BaseAction {

        public AddItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            tracker.add(new Item(name, desc));
        }
    }

    private static class ShowItems extends BaseAction {

        public ShowItems(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.getAll()) {
                System.out.println(String.format("%s. %s, %s.", item.getId(), item.getName(), item.getDescription()));
            }
        }
    }

    private static class EditItem extends BaseAction {

        public EditItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Редактирование новой заявки --------------");
            String id = input.ask("Введите идентификатор заявки: ");
            String name = input.ask("Введите новое имя заявки: ");
            String desc = input.ask("Введите новое описание заявки: ");
            Item item = new Item(name, desc);
            if (tracker.replace(id, item)) {
                System.out.println("---------- Заявка отредактирована -----------");
            } else {
                System.out.println("------ Заявка с данным идентификатором не найдена ------");
            }
        }
    }

    private static class DeleteItem extends BaseAction {

        public DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Удаление заявки --------------");
            String id = input.ask("Введите идентификатор заявки: ");
            if (tracker.delete(id)) {
                System.out.println("---------- Заявка удалена -----------");
            } else {
                System.out.println("---------- Заявка с данным идентификатором не найдена -----------");
            }
        }
    }

    private static class FindItemById extends BaseAction {

        public FindItemById(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("---------- Поиск заявки по идентификатору -----------");
            String id = input.ask("Введите идентификатор заявки: ");
            Item item = tracker.findById(id);
            if (item == null) {
                System.out.println("---------- Заявка с данным идентификатором не найдена -----------");
            } else {
                System.out.println("---------- Данные по заявке -----------");
                System.out.println(item);
            }
        }
    }

    private static class FindItemByName extends BaseAction {

        public FindItemByName(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("---------- Поиск заявки по имени -----------");
            String name = input.ask("Введите имя заявки: ");
            List<Item> items = tracker.findByName(name);
            if (items.size() == 0) {
                System.out.println("--------- Заявки с данным наименованием не найдены -----------");
            } else {
                System.out.println("---------- Найденные заявки -----------");
                for (Item item : items) {
                    System.out.println(item);
                }
            }
        }
    }
}
