package ru.job4j.inout;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ScriptTest {
    private Map<Integer, List<Integer>> map;

    @Before
    public void createMap() {
        map = new HashMap<>();
        map.put(1, List.of(2, 3));
        map.put(2, List.of(4));
        map.put(3, List.of(4, 5));
        map.put(4, List.of());
        map.put(5, List.of());
    }

    @Test
    public void whenPutValueOneThenGetValuesTwoThreeFourFive() {
        Script script = new Script();
        List result = script.load(map, 1);
        List expect = List.of(2, 3, 4, 5);
        assertThat(result, is(expect));
    }

    @Test
    public void whenPutValueThreeThenGetValuesFourFive() {
        Script script = new Script();
        List result = script.load(map, 3);
        List expect = List.of(4, 5);
        assertThat(result, is(expect));
    }
}
