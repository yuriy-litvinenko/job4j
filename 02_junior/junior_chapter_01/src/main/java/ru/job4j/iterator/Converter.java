package ru.job4j.iterator;

import java.util.*;

class Converter {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<>() {
            private Iterator<Integer> itTmp = new ArrayList<Integer>().iterator();

            private void nextCheck() {
                while (!itTmp.hasNext() && it.hasNext()) {
                    itTmp = it.next();
                }
            }

            @Override
            public boolean hasNext() {
                nextCheck();
                return itTmp.hasNext();
            }

            @Override
            public Integer next() {
                nextCheck();
                if (itTmp.hasNext()) {
                    return itTmp.next();
                }
                throw new NoSuchElementException();
            }
        };
    }
}
