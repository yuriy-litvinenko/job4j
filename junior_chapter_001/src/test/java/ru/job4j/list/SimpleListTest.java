package ru.job4j.list;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class SimpleListTest {

    @Test
    public void addAndGetValuesFromDynamicArray() {
        SimpleList<Integer> simpleList = new SimpleList<>();
        simpleList.add(1);
        simpleList.add(2);
        simpleList.add(3);
        simpleList.add(4);
        simpleList.add(5);
        assertThat(simpleList.get(4), is(5));
        assertThat(simpleList.get(5), is(nullValue()));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void getArrayValuesWithIteratorAndThrowException() {
        SimpleList<Integer> simpleList = new SimpleList<>();
        simpleList.add(1);
        simpleList.add(2);
        Iterator it = simpleList.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(false));
        simpleList.add(3);
        it.next();
    }
}
