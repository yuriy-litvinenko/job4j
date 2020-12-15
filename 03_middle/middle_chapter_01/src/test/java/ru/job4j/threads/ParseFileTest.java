package ru.job4j.threads;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.function.Predicate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

public class ParseFileTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();
    private Predicate<Integer> predUnicode = i -> i < 0x0800;
    private Predicate<Integer> predNoneUnicode = i -> i < 0x80;

    @Test
    public void textFileInUTF8GetWithUnicodeAndNotGetWithoutUnicode() throws IOException {
        SaveFile saveFile = new SaveFile();
        ParseFile parseFile = new ParseFile();
        File sourceFile = folder.newFile("test.txt");
        saveFile.setFile(sourceFile);
        String input = "Текст в кодировке UTF-8";
        saveFile.saveContent(input, StandardCharsets.UTF_8);
        parseFile.setFile(saveFile.getFile());
        String resultWithUnicode = parseFile.getContent(predUnicode);
        assertThat(resultWithUnicode, is(input));
        String resultWithoutUnicode = parseFile.getContent(predNoneUnicode);
        assertThat(resultWithoutUnicode, is(not(input)));
    }

    @Test
    public void textFileInASCIIGetWithUnicodeAndGetWithoutUnicode() throws IOException {
        SaveFile saveFile = new SaveFile();
        ParseFile parseFile = new ParseFile();
        File sourceFile = folder.newFile("test.txt");
        saveFile.setFile(sourceFile);
        String input = "Text encoded ASCII";
        saveFile.saveContent(input, StandardCharsets.US_ASCII);
        parseFile.setFile(saveFile.getFile());
        String resultWithUnicode = parseFile.getContent(predUnicode);
        assertThat(resultWithUnicode, is(input));
        String resultWithoutUnicode = parseFile.getContent(predNoneUnicode);
        assertThat(resultWithoutUnicode, is(input));
    }
}
