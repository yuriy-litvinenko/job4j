package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.nullValue;

public class StartUITest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final StringBuilder menu = new StringBuilder()
            .append("Меню.")
            .append(System.lineSeparator())
            .append("0 - Добавить новую заявку")
            .append(System.lineSeparator())
            .append("1 - Показать все заявки")
            .append(System.lineSeparator())
            .append("2 - Редактировать заявку")
            .append(System.lineSeparator())
            .append("3 - Удалить заявку")
            .append(System.lineSeparator())
            .append("4 - Найти заявку по идентификатору")
            .append(System.lineSeparator())
            .append("5 - Найти заявку по имени")
            .append(System.lineSeparator())
            .append("6 - Выйти из программы")
            .append(System.lineSeparator());

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.getAll().get(0).getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenDeleteItemThenTrackerDeleteItemWithSameId() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenGetAllThenTrackerShowAllItems() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test name 1", "desc 1"));
        Item item2 = tracker.add(new Item("test name 2", "desc 2"));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(menu)
                                .append("------------ Список имеющихся заявок --------------")
                                .append(System.lineSeparator())
                                .append(item1)
                                .append(System.lineSeparator())
                                .append(item2)
                                .append(System.lineSeparator())
                                .append(menu)
                                .toString()
                )
        );
    }

    @Test
    public void whenFindItemByIdThenTrackerShowFindItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name 1", "desc 1"));
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(menu)
                                .append("---------- Поиск заявки по идентификатору -----------")
                                .append(System.lineSeparator())
                                .append("---------- Данные по заявке -----------")
                                .append(System.lineSeparator())
                                .append(item)
                                .append(System.lineSeparator())
                                .append(menu)
                                .toString()
                )
        );
    }

    @Test
    public void whenFindItemsByNameThenTrackerShowFindItems() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test name 1", "desc 1"));
        Item item2 = tracker.add(new Item("test name 1", "desc 2"));
        Input input = new StubInput(new String[]{"5", item1.getName(), "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(menu)
                                .append("---------- Поиск заявки по имени -----------")
                                .append(System.lineSeparator())
                                .append("---------- Найденные заявки -----------")
                                .append(System.lineSeparator())
                                .append(item1)
                                .append(System.lineSeparator())
                                .append(item2)
                                .append(System.lineSeparator())
                                .append(menu)
                                .toString()
                )
        );
    }
}
