package ru.job4j.gc;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class SoftWeakCache implements Cache<String, String> {
    private static Map<String, SoftReference<String>> cache = new HashMap<>();

    @Override
    public String get(String key) {
        SoftReference<String> result = cache.get(key);
        if (result == null) {
            this.put(key);
            result = cache.get(key);
        }
        return result.get();
    }

    @Override
    public void put(String key) {
        String content = null;
        try {
            content = new String(Files.readAllBytes(Paths.get(key)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (content != null) {
            cache.put(key, new SoftReference<>(content));
        }
    }
}
