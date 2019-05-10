package ru.job4j.inout;

import java.io.File;
import java.util.*;

class Search {
    List<File> files(String parent, List<String> exts) {
        List<File> result = new ArrayList<>();
        Queue<File> data = new LinkedList<>();
        data.offer(new File(parent));
        while (!data.isEmpty()) {
            File el = data.poll();
            if (el.isDirectory()) {
                for (File f : Objects.requireNonNull(el.listFiles())) {
                    data.offer(f);
                }
            } else {
                if (checkExt(el.getName(), exts)) {
                    result.add(el);
                }
            }
        }
        return result;
    }

    private boolean checkExt(String fileName, List<String> exts) {
        boolean result = false;
        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            String ext = fileName.substring(i + 1);
            for (String e : exts) {
                if (e.equals(ext)) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}
