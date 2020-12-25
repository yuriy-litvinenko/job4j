package ru.job4j.threads;

import net.jcip.annotations.ThreadSafe;

import java.util.HashMap;
import java.util.Map;

@ThreadSafe
class UserStorage {
    private final Map<Integer, User> userList = new HashMap<>();

    boolean add(User user) {
        if (!userList.containsKey(user.getId())) {
            userList.put(user.getId(), user);
            return true;
        }
        return false;
    }

    boolean update(User user) {
        if (userList.containsKey(user.getId())) {
            userList.put(user.getId(), user);
            return true;
        }
        return false;
    }

    boolean delete(User user) {
        if (userList.containsKey(user.getId())) {
            userList.remove(user.getId());
            return true;
        }
        return false;

    }

    synchronized void transfer(int fromId, int toId, int amount) {
        User userFrom = userList.get(fromId);
        User userTo = userList.get(toId);
        if (userFrom != null && userTo != null) {
            if (userFrom.getAmount() >= amount) {
                userFrom.setAmount(userFrom.getAmount() - amount);
                userTo.setAmount(userTo.getAmount() + amount);
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Map<Integer, User> getUserList() {
        return userList;
    }
}
