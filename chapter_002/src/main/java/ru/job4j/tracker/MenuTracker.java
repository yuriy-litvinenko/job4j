package ru.job4j.tracker;

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[6];

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillActions() {
        this.actions[0] = new MenuTracker.AddItem();
        this.actions[1] = new MenuTracker.ShowItems();
        this.actions[2] = new MenuTracker.EditItem();
        this.actions[3] = new MenuTracker.DeleteItem();
        this.actions[4] = new MenuTracker.FindItemById();
        this.actions[5] = new MenuTracker.FindItemByName();
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

    private static class AddItem implements UserAction {
        @Override
        public int key() {
            return 0;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            tracker.add(new Item(name, desc));
        }

        @Override
        public String info() {
            return String.format("%s. %s,", this.key(), "Добавить новую заявку");
        }
    }

    private static class ShowItems implements UserAction {
        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.getAll()) {
                System.out.println(String.format("%s. %s, %s.", item.getId(), item.getName(), item.getDescription()));
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s,", this.key(), "Показать все заявки");
        }
    }

    private static class EditItem implements UserAction {
        @Override
        public int key() {
            return 2;
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

        @Override
        public String info() {
            return String.format("%s. %s,", this.key(), "Редактировать заявку");
        }
    }

    private static class DeleteItem implements UserAction {
        @Override
        public int key() {
            return 3;
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

        @Override
        public String info() {
            return String.format("%s. %s,", this.key(), "Удалить заявку.");
        }
    }

    private static class FindItemById implements UserAction {
        @Override
        public int key() {
            return 4;
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

        @Override
        public String info() {
            return String.format("%s. %s,", this.key(), "Найти заявку по идентификатору");
        }
    }

    private static class FindItemByName implements UserAction {
        @Override
        public int key() {
            return 5;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("---------- Поиск заявки по имени -----------");
            String name = input.ask("Введите имя заявки: ");
            Item[] items = tracker.findByName(name);
            if (items.length == 0) {
                System.out.println("--------- Заявки с данным наименованием не найдены -----------");
            } else {
                System.out.println("---------- Найденные заявки -----------");
                for (Item item : items) {
                    System.out.println(item);
                }
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s,", this.key(), "Найти заявку по имени");
        }
    }
}
