package ru.job4j.tracker;

public class StartUI {
    private static final String ADD = "0";
    private static final String SHOW_ALL = "1";
    private static final String EDIT = "2";
    private static final String DEL = "3";
    private static final String FIND_ID = "4";
    private static final String FIND_NAME = "5";
    private static final String EXIT = "6";

    private final Input input;

    private final Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        do {
            menu.show();
            int key = Integer.valueOf(input.ask("Select: "));
            menu.select(key);
        } while (!"y".equals(this.input.ask("Exit?(y): ")));
    }

    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с Id : " + item.getId() + "-----------");
    }

    private void showAllItems() {
        System.out.println("------------ Список имеющихся заявок --------------");
        Item[] result = this.tracker.getAll();
        for (Item item : result) {
            System.out.println(item);
        }
    }

    private void editItem() {
        System.out.println("------------ Редактирование новой заявки --------------");
        String id = this.input.ask("Введите идентификатор заявки: ");
        String name = this.input.ask("Введите новое имя заявки: ");
        String desc = this.input.ask("Введите новое описание заявки: ");
        Item item = new Item(name, desc);
        if (tracker.replace(id, item)) {
            System.out.println("---------- Заявка отредактирована -----------");
        } else {
            System.out.println("------ Заявка с данным идентификатором не найдена ------");
        }
    }

    private void deleteItem() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите идентификатор заявки: ");
        if (tracker.delete(id)) {
            System.out.println("---------- Заявка удалена -----------");
        } else {
            System.out.println("---------- Заявка с данным идентификатором не найдена -----------");
        }
    }

    private void findItemById() {
        System.out.println("---------- Поиск заявки по идентификатору -----------");
        String id = this.input.ask("Введите идентификатор заявки: ");
        Item item = tracker.findById(id);
        if (item == null) {
            System.out.println("---------- Заявка с данным идентификатором не найдена -----------");
        } else {
            System.out.println("---------- Данные по заявке -----------");
            System.out.println(item);
        }
    }

    private void findItemByName() {
        System.out.println("---------- Поиск заявки по имени -----------");
        String name = this.input.ask("Введите имя заявки: ");
        Item[] items = tracker.findByName(name);
        if (items.length == 0) {
            System.out.println("---------- Заявки с данным наименованием не найдены -----------");
        } else {
            System.out.println("---------- Найденные заявки -----------");
            for (Item item : items) {
                System.out.println(item);
            }
        }
    }

    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0 - Добавить новую заявку");
        System.out.println("1 - Показать все заявки");
        System.out.println("2 - Редактировать заявку");
        System.out.println("3 - Удалить заявку");
        System.out.println("4 - Найти заявку по идентификатору");
        System.out.println("5 - Найти заявку по имени");
        System.out.println("6 - Выйти из программы");
    }

    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
