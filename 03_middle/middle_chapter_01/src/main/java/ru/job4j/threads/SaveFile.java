package ru.job4j.threads;

import java.io.*;
import java.nio.charset.Charset;

class SaveFile {
    private File file;

    synchronized void setFile(File f) {
        file = f;
    }

    synchronized File getFile() {
        return file;
    }

    synchronized void saveContent(String content, Charset charsets) {
        try (Writer out = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(file), charsets))) {
            out.append(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
