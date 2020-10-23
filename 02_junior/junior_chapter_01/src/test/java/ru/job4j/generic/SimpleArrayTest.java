package ru.job4j.generic;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SimpleArrayTest {

    @Test
    public void testOperationsWithSimpleArrayOfInteger() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(10);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.add(4);
        simpleArray.add(5);
        simpleArray.set(1, 6);
        assertThat(simpleArray.get(1), is(6));
        simpleArray.remove(3);
        assertThat(simpleArray.get(3), is(5));
        assertThat(simpleArray.get(4), is(nullValue()));
    }

    @Test
    public void testOperationsWithSimpleArrayOfString() {
        SimpleArray<String> simpleArray = new SimpleArray<>(10);
        simpleArray.add("1");
        simpleArray.add("2");
        simpleArray.add("3");
        simpleArray.add("4");
        simpleArray.add("5");
        simpleArray.set(1, "6");
        assertThat(simpleArray.get(1), is("6"));
        simpleArray.remove(3);
        assertThat(simpleArray.get(3), is("5"));
        assertThat(simpleArray.get(4), is(nullValue()));
    }

    @Test(expected = NoSuchElementException.class)
    public void testSimpleArrayIteratorWithException() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(10);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        Iterator it = simpleArray.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(false));
        it.next();
    }
}
