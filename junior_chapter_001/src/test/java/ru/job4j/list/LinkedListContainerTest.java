package ru.job4j.list;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LinkedListContainerTest {
    @Test(expected = IndexOutOfBoundsException.class)
    public void addGetAndRemoveIntegerValuesFromLinkedListAndThrowException() {
        LinkedListContainer<Integer> linkedListContainer = new LinkedListContainer<>();
        linkedListContainer.add(1);
        linkedListContainer.add(2);
        linkedListContainer.add(3);
        linkedListContainer.add(4);
        linkedListContainer.add(5);
        assertThat(linkedListContainer.get(0), is(1));
        assertThat(linkedListContainer.get(3), is(4));
        assertThat(linkedListContainer.remove(3), is(4));
        assertThat(linkedListContainer.get(3), is(5));
        linkedListContainer.get(5);
    }

    @Test(expected = ConcurrentModificationException.class)
    public void getValuesFromLinkedListWithIteratorAndThrowException() {
        LinkedListContainer<Integer> linkedListContainer = new LinkedListContainer<>();
        linkedListContainer.add(1);
        linkedListContainer.add(2);
        Iterator it = linkedListContainer.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(false));
        linkedListContainer.add(3);
        it.next();
    }
}
