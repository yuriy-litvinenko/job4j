package ru.job4j.sort;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class SortUser {
    Set<User> sort(List<User> users) {
        return new TreeSet<>(users);
    }

    List<User> sortNameLength(List<User> users) {
        users.sort(
                Comparator.comparingInt(o -> o.getName().length())
        );
        return users;
    }

    List<User> sortByAllFields(List<User> users) {
        users.sort(
                Comparator.comparing(User::getName).thenComparingInt(User::getAge)
        );
        return users;
    }
}
