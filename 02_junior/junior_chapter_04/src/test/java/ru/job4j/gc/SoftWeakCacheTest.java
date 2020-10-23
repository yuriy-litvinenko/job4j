package ru.job4j.gc;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringJoiner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SoftWeakCacheTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void getFileContentFromCache() throws IOException {
        File sourceFile = folder.newFile("Names.txt");
        try (PrintWriter out = new PrintWriter(sourceFile)) {
            out.println("John");
            out.println("Mike");
            out.print("Kevin");
        }
        String source = new StringJoiner(System.lineSeparator()).add("John").add("Mike").add("Kevin").toString();
        String target = new SoftWeakCache().get(sourceFile.getAbsolutePath());
        assertThat(target, is(source));
    }
}
