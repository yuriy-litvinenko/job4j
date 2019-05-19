package ru.job4j.inout;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SearchTest {

    @Test
    public void createFileStructureAndGetFromItListOfFilesWithGivenExtension() {
        File dir1 = new File(System.getProperty("java.io.tmpdir") + "Dir1");
        File dir2 = new File(dir1 + "\\Dir2");
        File dir3 = new File(dir1 + "\\Dir3");
        File dir4 = new File(dir2 + "\\Dir4");
        File dir5 = new File(dir4 + "\\Dir5");
        File file1 = new File(dir1 + "\\file1.txt");
        File file2 = new File(dir1 + "\\file2.bmp");
        File file3 = new File(dir2 + "\\file3.txt");
        File file4 = new File(dir3 + "\\file4.rtf");
        File file5 = new File(dir3 + "\\file5.txt");
        File file6 = new File(dir3 + "\\file6.bmp");
        File file7 = new File(dir4 + "\\file7.txt");
        File file8 = new File(dir4 + "\\file8.rtf");
        File file9 = new File(dir5 + "\\file9.txt");
        File file10 = new File(dir5 + "\\file10.bmp");
        File file11 = new File(dir5 + "\\file11.rtf");
        try {
            dir1.mkdir();
            dir2.mkdir();
            dir3.mkdir();
            dir4.mkdir();
            dir5.mkdir();
            file1.createNewFile();
            file2.createNewFile();
            file3.createNewFile();
            file4.createNewFile();
            file5.createNewFile();
            file6.createNewFile();
            file7.createNewFile();
            file8.createNewFile();
            file9.createNewFile();
            file10.createNewFile();
            file11.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String parent = System.getProperty("java.io.tmpdir") + "Dir1";
        List<String> exts = List.of("txt", "bmp");
        Search search = new Search();
        List<File> result = search.files(parent, exts);
        List<File> expect = List.of(file1, file2, file3, file5, file6, file7, file10, file9);
        assertThat(result, is(expect));
    }
}
