package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

class MenuTracker {
    private Input input;
    private ITracker tracker;
    private List<UserAction> actions = new ArrayList<>();
    private final Consumer<String> output;

    int[] getActionsKeys() {
        int[] actionsKey = new int[actions.size()];
        for (int index = 0; index < actions.size(); index++) {
            actionsKey[index] = actions.get(index).key();
        }
        return actionsKey;
    }

    MenuTracker(Input input, ITracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    void fillActions() {
        this.actions.add(new MenuTracker.AddItem(0, "Добавить новую заявку"));
        this.actions.add(new MenuTracker.ShowItems(1, "Показать все заявки"));
        this.actions.add(new MenuTracker.EditItem(2, "Редактировать заявку"));
        this.actions.add(new MenuTracker.DeleteItem(3, "Удалить заявку"));
        this.actions.add(new MenuTracker.FindItemById(4, "Найти заявку по идентификатору"));
        this.actions.add(new MenuTracker.FindItemByName(5, "Найти заявку по имени"));
    }

    void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                output.accept(action.info());
            }
        }
    }

    private static class AddItem extends BaseAction {

        AddItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, ITracker tracker) {
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            tracker.add(new Item(name, desc));
        }
    }

    private class ShowItems extends BaseAction {

        ShowItems(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, ITracker tracker) {
            for (Item item : tracker.getAll()) {
                output.accept(item.toString());
            }
        }
    }

    private class EditItem extends BaseAction {

        EditItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, ITracker tracker) {
            output.accept("------------ Редактирование новой заявки --------------");
            String id = input.ask("Введите идентификатор заявки: ");
            String name = input.ask("Введите новое имя заявки: ");
            String desc = input.ask("Введите новое описание заявки: ");
            Item item = new Item(name, desc);
            if (tracker.replace(id, item)) {
                output.accept("---------- Заявка отредактирована -----------");
            } else {
                output.accept("------ Заявка с данным идентификатором не найдена ------");
            }
        }
    }

    private class DeleteItem extends BaseAction {

        DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, ITracker tracker) {
            output.accept("------------ Удаление заявки --------------");
            String id = input.ask("Введите идентификатор заявки: ");
            if (tracker.delete(id)) {
                output.accept("---------- Заявка удалена -----------");
            } else {
                output.accept("---------- Заявка с данным идентификатором не найдена -----------");
            }
        }
    }

    private class FindItemById extends BaseAction {

        FindItemById(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, ITracker tracker) {
            output.accept("---------- Поиск заявки по идентификатору -----------");
            String id = input.ask("Введите идентификатор заявки: ");
            Item item = tracker.findById(id);
            if (item == null) {
                output.accept("---------- Заявка с данным идентификатором не найдена -----------");
            } else {
                output.accept("---------- Данные по заявке -----------");
                output.accept(item.toString());
            }
        }
    }

    private class FindItemByName extends BaseAction {

        FindItemByName(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, ITracker tracker) {
            output.accept("---------- Поиск заявки по имени -----------");
            String name = input.ask("Введите имя заявки: ");
            List<Item> items = tracker.findByName(name);
            if (items.size() == 0) {
                output.accept("--------- Заявки с данным наименованием не найдены -----------");
            } else {
                output.accept("---------- Найденные заявки -----------");
                for (Item item : items) {
                    output.accept(item.toString());
                }
            }
        }
    }
}
