package ru.job4j.inout;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<>();

    Config(final String path) {
        this.path = path;
    }

    void load() {
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            String str;
            while ((str = read.readLine()) != null) {
                if (str.length() != 0 && str.charAt(0) != '#' && str.contains("=")) {
                    values.put(str.substring(0, str.indexOf("=")), str.substring(str.indexOf("=") + 1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }
}
