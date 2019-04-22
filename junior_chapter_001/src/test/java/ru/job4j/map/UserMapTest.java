package ru.job4j.map;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class UserMapTest {

    @Test
    public void hashMapPutAndGetTest() {
        Calendar dateBirth = new GregorianCalendar(1985, Calendar.AUGUST, 10);
        User user1 = new User("Yuriy", 2, dateBirth);
        User user2 = new User("Yuriy", 2, dateBirth);
        Map<User, Object> userMap = new HashMap<>();
        userMap.put(user1, "first");
        userMap.put(user2, "second");
        System.out.println(userMap);
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
        System.out.println(user1.equals(user2));
    }
}
