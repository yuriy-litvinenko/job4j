package ru.job4j.list;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class LinkedListContainerTest {
    @Test
    public void addAndGetIntegerValuesFromNodeArray() {
        LinkedListContainer<Integer> linkedListContainer = new LinkedListContainer<>();
        linkedListContainer.add(1);
        linkedListContainer.add(2);
        linkedListContainer.add(3);
        linkedListContainer.add(4);
        linkedListContainer.add(5);
        assertThat(linkedListContainer.get(4), is(5));
        assertThat(linkedListContainer.get(5), is(nullValue()));
    }

    @Test
    public void addAndGetStringValuesFromNodeArray() {
        LinkedListContainer<String> linkedListContainer = new LinkedListContainer<>();
        linkedListContainer.add("1");
        linkedListContainer.add("2");
        linkedListContainer.add("3");
        linkedListContainer.add("4");
        linkedListContainer.add("5");
        assertThat(linkedListContainer.get(4), is("5"));
        assertThat(linkedListContainer.get(5), is(nullValue()));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void getArrayValuesWithIteratorAndThrowException() {
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
