package ru.job4j.department;

import java.util.TreeSet;

public class DepartmentSort {
    private TreeSet<String> deps = new TreeSet<>();

    public void addDepartment(String dep) {
        for (int i = 0; i < dep.length(); i++) {
            if (dep.charAt(i) == '\\') {
                deps.add(dep.substring(0, i));
            }
        }
        deps.add(dep);
    }

    public TreeSet<String> sortDepsAsc() {
        return deps;
    }

    public TreeSet<String> sortDepsDesc() {
        TreeSet<String> result = new TreeSet<>(
                (String o1, String o2) -> {
                    int minSize = (o1.length() <= o2.length()) ? o1.length() : o2.length();
                    for (int i = 0; i < minSize; i++) {
                        if (o1.charAt(i) > o2.charAt(i)) {
                            return -1;
                        }
                    }
                    return (o1.equals(o2)) ? 0 : 1;
                }
        );
        result.addAll(deps);
        return result;
    }
}
