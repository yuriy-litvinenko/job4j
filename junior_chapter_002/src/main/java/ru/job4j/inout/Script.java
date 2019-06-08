package ru.job4j.inout;

import java.util.*;

class Script {
    private Set<Integer> set = new HashSet<>();

    List load(Map<Integer, List<Integer>> ds, Integer scriptId) {
        List<Integer> listTmp = ds.get(scriptId);
        for (int script : listTmp) {
            set.add(script);
            this.load(ds, script);
        }
        return new ArrayList<>(set);
    }
}
