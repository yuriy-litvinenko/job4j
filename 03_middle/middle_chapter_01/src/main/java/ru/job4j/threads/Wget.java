package ru.job4j.threads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Wget {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String filePath = args[0];
        int speedLimit = Integer.parseInt(args[1]) * 1024;
        String fileName = filePath.substring(filePath.lastIndexOf("/") + 1);
        FileDownloader downloader = new FileDownloader(filePath, speedLimit, fileName);
        FutureTask<Boolean> future = new FutureTask<>(downloader);
        new Thread(future).start();
        if (!future.isDone()) {
            System.out.println("File downloading. Please Wait...\r");
        }
        if (future.get()) {
            System.out.println("File " + fileName + " download successful");
        }
    }
}
