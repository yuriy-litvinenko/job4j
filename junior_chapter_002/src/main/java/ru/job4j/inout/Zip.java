package ru.job4j.inout;

import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    private static String exc;
    private List<File> fileList = new ArrayList<>();

    public static void main(String[] args) {
        String dir;
        String out;
        Args arguments = new Args(args);
        dir = arguments.directory();
        out = arguments.output();
        exc = arguments.exclude();
        new Zip().pack(new File(dir), new File(out));
    }

    private void pack(File source, File target) {
        fileList = getFileList(source.getPath());
        List<File> fileAddList = seekBy(exc);
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File f : Objects.requireNonNull(fileAddList)) {
                zip.putNextEntry(new ZipEntry(f.getPath().substring(2)));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(f))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<File> getFileList(String parent) {
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
                result.add(el);
            }
        }
        return result;
    }

    private List<File> seekBy(String ext) {
        List<File> result = new ArrayList<>();
        for (File f : fileList) {
            String fileName = f.getName();
            int i = fileName.lastIndexOf('.');
            if (i > 0) {
                String extCur = fileName.substring(i + 1);
                if (!extCur.equals(ext)) {
                    result.add(f);
                }
            }
        }
        return result;
    }

    public static class Args {
        String[] args;

        Args(String[] args) {
            this.args = args;
        }

        String directory() {
            String result = null;
            for (int i = 0; i != args.length; i++) {
                if (args[i].equals("-d")) {
                    result = args[i + 1];
                }
            }
            return result;
        }

        String exclude() {
            String result = null;
            for (int i = 0; i != args.length; i++) {
                if (args[i].equals("-e")) {
                    result = args[i + 1].substring(args[i + 1].lastIndexOf('.') + 1);
                }
            }
            return result;
        }

        String output() {
            String result = null;
            for (int i = 0; i != args.length; i++) {
                if (args[i].equals("-o")) {
                    result = args[i + 1];
                }
            }
            return result;
        }
    }
}
