package ru.job4j.set;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class SimpleSetTest {

    @Test
    public void whenAddValuesWithDublicatesToSetThenGetNoDublicatesSet() {
        SimpleSet<Integer> simpleSet = new SimpleSet<>();
        simpleSet.add(1);
        simpleSet.add(1);
        simpleSet.add(2);
        simpleSet.add(2);
        simpleSet.add(3);
        assertThat(simpleSet.get(0), is(1));
        assertThat(simpleSet.get(1), is(2));
        assertThat(simpleSet.get(2), is(3));
        assertThat(simpleSet.get(3), is(nullValue()));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void getValuesFromSetWithIteratorAndThrowException() {
        SimpleSet<Integer> simpleSet = new SimpleSet<>();
        simpleSet.add(1);
        simpleSet.add(2);
        Iterator it = simpleSet.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(false));
        simpleSet.add(3);
        it.next();
    }

    @Test
    public void whenAddValuesFiveNullFourThenGetTheseValues() {
        SimpleSet<Integer> simpleSet = new SimpleSet<>();
        simpleSet.add(5);
        simpleSet.add(null);
        simpleSet.add(4);
        assertThat(simpleSet.get(0), is(5));
        assertThat(simpleSet.get(1), is(nullValue()));
        assertThat(simpleSet.get(2), is(4));
    }
}
