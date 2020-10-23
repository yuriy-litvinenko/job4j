package ru.job4j.map;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class SimpleMapTest {
    @Test
    public void testingSimpleMapInsertGetDeleteMethods() {
        SimpleMap<User, String> userMap = new SimpleMap<>();
        User user1 = new User("Yuriy", 2, new GregorianCalendar(1985, Calendar.AUGUST, 10));
        User user2 = new User("Sergey", 2, new GregorianCalendar(1985, Calendar.MAY, 15));
        User user3 = new User("Michael", 0, new GregorianCalendar(1986, Calendar.JANUARY, 9));
        User user4 = new User("Dmitriy", 2, new GregorianCalendar(1986, Calendar.AUGUST, 13));
        assertThat(userMap.insert(user1, "first"), is(true));
        assertThat(userMap.insert(user2, "second"), is(true));
        assertThat(userMap.insert(user3, "third"), is(true));
        assertThat(userMap.insert(user4, "fourth"), is(true));
        assertThat(userMap.insert(new User("Dmitriy", 2, new GregorianCalendar(1986, Calendar.AUGUST, 13)), "fifth"), is(false));
        assertThat(userMap.get(new User("Yuriy", 2, new GregorianCalendar(1985, Calendar.AUGUST, 10))), is("first"));
        assertThat(userMap.get(new User("Sergey", 2, new GregorianCalendar(1985, Calendar.MAY, 15))), is("second"));
        assertThat(userMap.get(new User("Michael", 0, new GregorianCalendar(1986, Calendar.JANUARY, 9))), is("third"));
        assertThat(userMap.get(new User("Dmitriy", 2, new GregorianCalendar(1986, Calendar.AUGUST, 13))), is("fourth"));
        assertThat(userMap.delete(new User("Sergey", 2, new GregorianCalendar(1985, Calendar.MAY, 15))), is(true));
        assertThat(userMap.delete(new User("Sergey", 2, new GregorianCalendar(1985, Calendar.MAY, 15))), is(false));
        assertThat(userMap.get(new User("Sergey", 2, new GregorianCalendar(1985, Calendar.MAY, 15))), is(nullValue()));
    }
}
