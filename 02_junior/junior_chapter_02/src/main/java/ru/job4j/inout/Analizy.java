package ru.job4j.inout;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Analizy {

    void unavailable(String source, String target) {
        List<String> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            String str;
            int type;
            Date date;
            boolean shutdown = false;
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            while ((str = reader.readLine()) != null) {
                if (str.length() != 0) {
                    type = Integer.parseInt(str.substring(0, str.indexOf(" ")));
                    date = sdf.parse(str.substring(str.indexOf(" " + 1)));
                    if (!shutdown && type == 400 || type == 500) {
                        result.add(sdf.format(date) + ";");
                        shutdown = true;
                    }
                    if (shutdown && type == 200 || type == 300) {
                        result.add(sdf.format(date) + "\n");
                        shutdown = false;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(target))) {
            for (String line : result) {
                writer.write(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
