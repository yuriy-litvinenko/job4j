package ru.job4j.inout;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ConfigTest {

    @Test
    public void loadParamsFromFileAndGetThem() {
        String path = URLDecoder.decode(Objects.requireNonNull(Config.class.getClassLoader().getResource("app.properties")).getPath(), StandardCharsets.UTF_8);
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.dialect"), is("org.hibernate.dialect.PostgreSQLDialect"));
        assertThat(config.value("hibernate.connection.url"), is("jdbc:postgresql://127.0.0.1:5432/trackstudio"));
        assertThat(config.value("hibernate.connection.driver_class"), is("org.postgresql.Driver"));
        assertThat(config.value("hibernate.connection.username"), is("postgres"));
        assertThat(config.value("hibernate.connection.password"), is("password"));
    }
}
