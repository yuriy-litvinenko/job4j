package ru.job4j.inout;

import java.util.*;

class Script {

    List load(Map<Integer, List<Integer>> ds, Integer scriptId) {
        Queue<Integer> queue = new LinkedList<>(ds.get(scriptId));
        Set<Integer> set = new TreeSet<>(ds.get(scriptId));
        int value;
        while (!queue.isEmpty()) {
            value = queue.poll();
            queue.addAll(ds.get(value));
            set.addAll(ds.get(value));
        }
        return new ArrayList<>(set);
    }
}
