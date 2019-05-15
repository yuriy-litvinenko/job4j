package ru.job4j.inout;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AnalizyTest {

    @Test
    public void writeShutdownTimeFromLogToFileThenReadIt() {
        Analizy analizy = new Analizy();
        String source = URLDecoder.decode(Objects.requireNonNull(Config.class.getClassLoader().getResource("server.txt")).getPath(), StandardCharsets.UTF_8);
        String target = "target\\unavailable.csv";
        analizy.unavailable(source, target);
        try (BufferedReader readerTarget = new BufferedReader(new FileReader(target))) {
            assertThat(readerTarget.readLine(), is("10:57:01;10:59:01"));
            assertThat(readerTarget.readLine(), is("11:01:02;11:02:02"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
