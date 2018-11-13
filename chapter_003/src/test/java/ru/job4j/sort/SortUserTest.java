package ru.job4j.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void SortUsersTreeSetByAge() {
        List<User> users = new ArrayList<>();
        SortUser sortUser = new SortUser();
        User user1 = new User("Ivan", 30);
        User user2 = new User("Stepan", 20);
        User user3 = new User("Ravshan", 25);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        Set<User> result = sortUser.sort(users);
        Set<User> expect = new TreeSet<>();
        expect.add(user2);
        expect.add(user3);
        expect.add(user1);
        assertThat(result, is(expect));
    }
}
