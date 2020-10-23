package ru.job4j.tdd;

import javafx.util.Pair;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class SimpleGenerator {
    private final Pattern pattern = Pattern.compile("\\$\\{(.*?)}");

    String generate(String template, Pair[] keys) {
        String text = template;
        Matcher matcher = pattern.matcher(text);
        String value;
        boolean find;
        int keyCount = 0;
        while (matcher.find()) {
            find = false;
            keyCount++;
            String replaceVal = text.substring(matcher.start(), matcher.end());
            for (Pair pair : keys) {
                if (pair.getKey().equals(replaceVal.substring(2, replaceVal.length() - 1))) {
                    value = pair.getValue().toString();
                    text = text.replace(replaceVal, value);
                    matcher = pattern.matcher(text);
                    find = true;
                    break;
                }
            }
            if (!find) {
                throw new KeysNotValidException("Key not found!");
            }
        }
        if (keys.length > keyCount) {
            throw new KeysNotValidException("Too many keys!");
        }
        return text;
    }
}
