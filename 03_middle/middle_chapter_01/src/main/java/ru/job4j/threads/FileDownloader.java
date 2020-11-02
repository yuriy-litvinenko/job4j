package ru.job4j.threads;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.Callable;

public class FileDownloader implements Callable<Boolean> {
    private String filePath;
    private int speedLimit;
    private String fileName;

    FileDownloader(String filePath, int speedLimit, String fileName) {
        this.filePath = filePath;
        this.speedLimit = speedLimit;
        this.fileName = fileName;
    }

    @Override
    public Boolean call() throws Exception {
        try (BufferedInputStream in = new BufferedInputStream(new URL(filePath).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            int bufferSize = 1024;
            byte[] res = new byte[bufferSize];
            int got;
            int byteLimit = 0;
            long startRec = System.currentTimeMillis();
            while ((got = in.read(res)) != -1) {
                fileOutputStream.write(res, 0, got);
                byteLimit = byteLimit + got;
                if (byteLimit > speedLimit) {
                    long endRec = System.currentTimeMillis();
                    long sleep = 1000 - (endRec - startRec);
                    if (sleep > 0) {
                        Thread.sleep(sleep);
                    }
                    startRec = System.currentTimeMillis();
                    byteLimit = 0;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
