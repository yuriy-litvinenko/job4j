package ru.job4j.control;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class GeneralParentTest {

    @Test
    public void getParentMethodTest() {
        assertThat(GeneralParent.getParent(9, 5), is(2));
        assertThat(GeneralParent.getParent(2, 3), is(1));
        assertThat(GeneralParent.getParent(10, 6), is(1));
    }
}
