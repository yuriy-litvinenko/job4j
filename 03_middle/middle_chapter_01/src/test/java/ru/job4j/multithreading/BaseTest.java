package ru.job4j.multithreading;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BaseTest {

    @Test
    public void addObjToCacheAndSuccesfullyUpdate() {
        CacheBase cache = new CacheBase();
        Base base = new Base(1, 0);
        Base base2 = new Base(1, 1);
        base.setName("Ivanov");
        cache.add(base);
        assertThat(cache.get(1).getName(), is("Ivanov"));
        base.setName("Morozov");
        cache.update(base);
        assertThat(cache.get(1).getName(), is("Morozov"));
        base2.setName("Petrov");
        cache.update(base2);
        assertThat(cache.get(1).getName(), is("Petrov"));
    }

    @Test(expected = OptimisticException.class)
    public void addObjToCacheAndGetExceptionVersionIsNotValidForUpdate() {
        CacheBase cache = new CacheBase();
        Base base = new Base(1, 0);
        base.setName("Ivanov");
        cache.add(base);
        base.setName("Morozov");
        cache.update(base);
        base.setName("Petrov");
        cache.update(base);
    }
}
