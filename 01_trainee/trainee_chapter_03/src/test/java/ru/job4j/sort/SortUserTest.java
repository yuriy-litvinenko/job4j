package ru.job4j.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void sortUsersTreeSetByAge() {
        List<User> users = new ArrayList<>();
        SortUser sortUser = new SortUser();
        User user1 = new User("Ravshan", 30);
        User user2 = new User("Ivan", 20);
        User user3 = new User("Stepan", 25);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        Set<User> result = sortUser.sort(users);
        Set<User> expect = Set.of(user2, user3, user1);
        assertThat(result, is(expect));
    }

    @Test
    public void sortListByNameLengthComparator() {
        SortUser sortUser = new SortUser();
        User user1 = new User("Ravshan", 30);
        User user2 = new User("Ivan", 20);
        User user3 = new User("Stepan", 25);
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        List<User> result = sortUser.sortNameLength(users);
        List<User> expect = List.of(user2, user3, user1);
        assertThat(result, is(expect));
    }

    @Test
    public void sortListByNameAndAgeComparator() {
        List<User> users = new ArrayList<>();
        SortUser sortUser = new SortUser();
        User user1 = new User("Sergey", 25);
        User user2 = new User("Ivan", 30);
        User user3 = new User("Sergey", 20);
        User user4 = new User("Ivan", 25);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        List<User> result = sortUser.sortByAllFields(users);
        List<User> expect = List.of(user4, user2, user3, user1);
        assertThat(result, is(expect));
    }
}
