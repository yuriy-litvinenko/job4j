package ru.job4j.inout;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class SearchTest {

    @Test
    public void createFileStructureAndGetFromItListOfFilesWithGivenExtension() {
        String separator = File.separator;
        String parent = System.getProperty("java.io.tmpdir") + separator + "Dir0" + separator;
        File dir1 = new File(parent);
        File dir2 = new File(dir1 + separator + "Dir2" + separator);
        File dir3 = new File(dir1 + separator + "Dir3" + separator);
        File dir4 = new File(dir2 + separator + "Dir4" + separator);
        File dir5 = new File(dir4 + separator + "Dir5" + separator);
        File file1 = new File(dir1 + separator + "file1.txt");
        File file2 = new File(dir1 + separator + "file2.bmp");
        File file3 = new File(dir2 + separator + "file3.txt");
        File file4 = new File(dir3 + separator + "file4.rtf");
        File file5 = new File(dir3 + separator + "file5.txt");
        File file6 = new File(dir3 + separator + "file6.bmp");
        File file7 = new File(dir4 + separator + "file7.txt");
        File file8 = new File(dir4 + separator + "file8.rtf");
        File file9 = new File(dir5 + separator + "file9.txt");
        File file10 = new File(dir5 + separator + "file10.bmp");
        File file11 = new File(dir5 + separator + "file11.rtf");
        File[] dirs = new File[]{dir1, dir2, dir3, dir4, dir5};
        File[] files = new File[]{file1, file2, file3, file4, file5, file6, file7, file8, file9, file10, file11};
        //noinspection ResultOfMethodCallIgnored
        Arrays.stream(dirs).filter(file -> !file.exists()).forEach(File::mkdir);
        Arrays.stream(files).filter(file -> !file.exists()).forEach(file -> {
            try {
                //noinspection ResultOfMethodCallIgnored
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        List<String> exts = List.of("txt", "bmp");
        Search search = new Search();
        List<File> result = search.files(parent, exts);
        List<File> expect = List.of(file1, file2, file3, file5, file6, file7, file9, file10);
        assertThat(result, containsInAnyOrder(expect.toArray()));
    }
}
