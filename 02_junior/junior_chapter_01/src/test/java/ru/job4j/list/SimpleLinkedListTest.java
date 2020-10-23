package ru.job4j.list;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleLinkedListTest {
    @Test(expected = IndexOutOfBoundsException.class)
    public void addGetAndRemoveIntegerValuesFromLinkedListAndThrowException() {
        SimpleLinkedList<Integer> simpleLinkedList = new SimpleLinkedList<>();
        simpleLinkedList.add(1);
        simpleLinkedList.add(2);
        simpleLinkedList.add(3);
        simpleLinkedList.add(4);
        simpleLinkedList.add(5);
        assertThat(simpleLinkedList.get(0), is(1));
        assertThat(simpleLinkedList.get(3), is(4));
        assertThat(simpleLinkedList.remove(3), is(4));
        assertThat(simpleLinkedList.get(3), is(5));
        simpleLinkedList.get(5);
    }

    @Test(expected = ConcurrentModificationException.class)
    public void getValuesFromLinkedListWithIteratorAndThrowException() {
        SimpleLinkedList<Integer> simpleLinkedList = new SimpleLinkedList<>();
        simpleLinkedList.add(1);
        simpleLinkedList.add(2);
        Iterator it = simpleLinkedList.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(false));
        simpleLinkedList.add(3);
        it.next();
    }
}
