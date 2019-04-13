package ru.job4j.list;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class DynamicArrayTest {

    @Test
    public void addAndGetValuesFromDynamicArray() {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();
        dynamicArray.add(1);
        dynamicArray.add(2);
        dynamicArray.add(3);
        dynamicArray.add(4);
        dynamicArray.add(5);
        assertThat(dynamicArray.get(4), is(5));
        assertThat(dynamicArray.get(5), is(nullValue()));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void getArrayValuesWithIteratorAndThrowException() {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();
        dynamicArray.add(1);
        dynamicArray.add(2);
        Iterator it = dynamicArray.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(false));
        dynamicArray.add(3);
        it.next();
    }
}
