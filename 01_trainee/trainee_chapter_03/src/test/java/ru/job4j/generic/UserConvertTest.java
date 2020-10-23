package ru.job4j.generic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {
    @Test
    public void convertListToHashMap() {
        UserConvert convert = new UserConvert();
        List<User> users = new ArrayList<>();
        User user1 = new User(1, "Ivan", "Moscow");
        User user2 = new User(2, "Ben", "New York");
        users.add(user1);
        users.add(user2);
        HashMap<Integer, User> result = convert.process(users);
        Map<Integer, User> expect = Map.of(1, user1, 2, user2);
        assertThat(result, is(expect));
    }
}
