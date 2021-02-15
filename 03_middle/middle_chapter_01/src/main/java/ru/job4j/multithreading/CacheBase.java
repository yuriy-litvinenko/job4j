package ru.job4j.multithreading;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CacheBase {
    private final Map<Integer, Base> memory = new ConcurrentHashMap<>();

    public boolean add(Base model) {
        return memory.putIfAbsent(model.getId(), model) == null;
    }

    public boolean update(Base model) {
        return memory.computeIfPresent(model.getId(), (key, value) -> {
            if (model.getVersion() != value.getVersion()) {
                throw new OptimisticException("Versions are not equal");
            }
            value = new Base(model.getId(), model.getVersion() + 1);
            value.setName(model.getName());
            return value;
        }) != null;
    }

    public void delete(Base model) {
        memory.remove(model.getId(), model);
    }

    public Base get(Integer key) {
        return memory.get(key);
    }
}
