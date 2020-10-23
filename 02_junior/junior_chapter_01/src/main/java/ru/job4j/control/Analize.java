package ru.job4j.control;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Analize {

    Info diff(List<User> prevList, List<User> curList) {
        int added;
        int deleted;
        int changed = 0;
        int notChanged = 0;
        Map<Integer, User> curMap = curList.stream().collect(Collectors.toMap(User::getId, x -> x));
        for (User prevUser : prevList) {
            if (curMap.containsKey(prevUser.id)) {
                if (curMap.get(prevUser.id).getName().equals(prevUser.getName())) {
                    notChanged++;
                } else {
                    changed++;
                }
            }
        }
        added = curList.size() - changed - notChanged;
        deleted = prevList.size() - changed - notChanged;
        return new Info(added, changed, deleted);
    }

    public static class User {
        int id;
        String name;

        User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        int getId() {
            return id;
        }

        String getName() {
            return name;
        }
    }

    public static class Info {
        int added;
        int changed;
        int deleted;

        Info(int added, int changed, int deleted) {
            this.added = added;
            this.changed = changed;
            this.deleted = deleted;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Info info = (Info) o;
            return added == info.added
                    && changed == info.changed
                    && deleted == info.deleted;
        }

        @Override
        public int hashCode() {
            return Objects.hash(added, changed, deleted);
        }
    }
}
