package ru.job4j.generic;

import java.util.HashMap;
import java.util.List;

class UserConvert {
    HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> hashUsers = new HashMap<>();
        for (User user : list) {
            hashUsers.put(user.getId(), user);
        }
        return hashUsers;
    }
}
