package ru.job4j.jdbc;

import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

class Config {
    private final Properties values = new Properties();

    Config(String confPath) {
        this.init(confPath);
    }

    private void init(String confPath) {
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream(confPath)) {
            values.load(Objects.requireNonNull(in));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    String get(String key) {
        return this.values.getProperty(key);
    }
}
