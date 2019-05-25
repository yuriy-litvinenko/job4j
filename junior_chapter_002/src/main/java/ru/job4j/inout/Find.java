package ru.job4j.inout;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Find {
    private Args arguments;
    private String dir;
    private String name;
    private FindMode mode;
    private String log;
    private List<File> fileList = new ArrayList<>();
    private final static String LN = System.lineSeparator();
    private final static String HINT = String.format("Некорректно указаны параметры поиска.%s"
            + "Команда для запуска должна иметь вид:%s"
            + "java -jar find.jar -d path -n *.* -f/-m/-r -o log%s"
            + "Где -d path - путь к директории, в которой будет осуществляться поиск файлов,%s"
            + "-n *.* - имя файла/маска/регулярное выражение,%s"
            + "-f/-m/-r - параметр поиска: по имени файла/по маске/по регулярному выражению.",
            LN, LN, LN, LN, LN);

    private Find(String[] args) {
        this.arguments = new Args(args);
        this.init();
    }

    private interface FindMode {
        void apply();
    }

    public static void main(String[] args) {
        Find find = new Find(args);
        if (find.keysValidate()) {
            find.mode.apply();
            find.writeResult();
        } else {
            System.out.println(HINT);
        }
    }

    private void init() {
        this.dir = arguments.dir;
        this.name = arguments.name;
        this.mode = arguments.mode;
        this.log = arguments.log;
    }

    private boolean keysValidate() {
        return this.dir != null && this.name != null && this.mode != null && this.log != null;
    }

    private void writeResult() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(log))) {
            for (File file : fileList) {
                writer.write(file.getPath() + LN);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private FindMode searchByName = () -> {
        Queue<File> data = new LinkedList<>();
        data.offer(new File(dir));
        while (!data.isEmpty()) {
            File el = data.poll();
            if (el.isDirectory()) {
                for (File f : Objects.requireNonNull(el.listFiles())) {
                    data.offer(f);
                }
            } else if (el.getName().equals(name)) {
                fileList.add(el);
            }
        }
    };

    private FindMode searchByMask = () -> {
        Queue<File> data = new LinkedList<>();
        data.offer(new File(dir));
        name = name.replace(".", "\\.").replace("*", ".*").replace("?", ".");
        while (!data.isEmpty()) {
            File el = data.poll();
            if (el.isDirectory()) {
                for (File f : Objects.requireNonNull(el.listFiles())) {
                    data.offer(f);
                }
            } else if (el.getName().matches(name)) {
                fileList.add(el);
            }
        }
    };

    private FindMode searchByRegular = () -> {
        Queue<File> data = new LinkedList<>();
        data.offer(new File(dir));
        Pattern pattern = Pattern.compile(name);
        Matcher matcher;
        while (!data.isEmpty()) {
            File el = data.poll();
            matcher = pattern.matcher(el.getName());
            if (el.isDirectory()) {
                for (File f : Objects.requireNonNull(el.listFiles())) {
                    data.offer(f);
                }
            } else if (matcher.matches()) {
                fileList.add(el);
            }
        }
    };

    public class Args {
        String[] args;
        private String dir;
        private String name;
        private FindMode mode;
        private String log;

        Args(String[] args) {
            this.args = args;
            this.init();
        }

        void init() {
            for (int i = 0; i != args.length; i++) {
                switch (args[i]) {
                    case "-d":
                        dir = args[i + 1];
                        break;
                    case "-n":
                        name = args[i + 1];
                        break;
                    case "-f":
                        mode = searchByName;
                        break;
                    case "-m":
                        mode = searchByMask;
                        break;
                    case "-r":
                        mode = searchByRegular;
                        break;
                    case "-o":
                        log = args[i + 1];
                        break;
                    default:
                }
            }
        }
    }
}
