package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.getAll()[0], is(item));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 1234L);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenDeleteItemThenReplaceArray() {
        Tracker result = new Tracker();
        Item item1 = new Item("test1", "testDescription", 123L);
        Item item2 = new Item("test2", "testDescription2", 1234L);
        Item item3 = new Item("test3", "testDescription3", 12345L);
        result.add(item1);
        result.add(item2);
        result.add(item3);
        result.delete(item2.getId());
        Tracker expect = new Tracker();
        expect.add(item1);
        expect.add(item3);
        for (int index = 0; index != expect.getAll().length; index++) {
            assertThat(result.getAll()[index], is(expect.getAll()[index]));
        }
    }

    @Test
    public void whenGetAllItemsThenReturnAllItemsOfArray() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription", 123L);
        Item item2 = new Item("test2", "testDescription2", 1234L);
        Item item3 = new Item("test3", "testDescription3", 12345L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        assertThat(tracker.getAll()[0].getName(), is(item1.getName()));
        assertThat(tracker.getAll()[1].getName(), is(item2.getName()));
        assertThat(tracker.getAll()[2].getName(), is(item3.getName()));
    }

    @Test
    public void whenFindByNameThenReturnEqualItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription", 123L);
        Item item2 = new Item("test2", "testDescription2", 1234L);
        Item item3 = new Item("test1", "testDescription3", 12345L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        Item[] result = tracker.findByName(item1.getName());
        assertThat(result[0].getName(), is("test1"));
        assertThat(result[1].getName(), is("test1"));
    }

    @Test
    public void whenFindByIdThenReturnEqualItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription", 123L);
        Item item2 = new Item("test2", "testDescription2", 1234L);
        tracker.add(item1);
        tracker.add(item2);
        String result = tracker.findById(item2.getId()).getName();
        String expect = item2.getName();
        assertThat(result, is(expect));
    }
}
