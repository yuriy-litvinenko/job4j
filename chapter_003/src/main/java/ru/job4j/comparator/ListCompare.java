package ru.job4j.comparator;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int minSize = (o1.length() < o2.length() ? o1.length() : o2.length());
        for (int index = 0; index < minSize; index++) {
            int result = Character.compare(o1.charAt(index), o2.charAt(index));
            if (result != 0) {
                return result;
            }
        }
        return o1.length() - o2.length();
    }
}
