package ru.job4j.multithreading;

import java.io.*;
import java.util.function.Predicate;

class ParseFile {
    private File file;

    synchronized void setFile(File f) {
        file = f;
    }

    synchronized String getContent(Predicate<Integer> pred) {
        StringBuilder output = new StringBuilder();
        try (FileReader i = new FileReader(file)) {
            int data;
            while ((data = i.read()) > 0) {
                if (pred.test(data)) {
                    output.append((char) data);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output.toString();
    }
}
