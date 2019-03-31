package ru.job4j.streamnew;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Students {
    public List<Student> levelOf(List<Student> students, int bound) {
        return students.stream().sorted(Comparator.nullsLast((o1, o2) -> o2.getScope() - o1.getScope()))
                .flatMap(Stream::ofNullable).takeWhile(s -> s.getScope() > bound).collect(Collectors.toList());
    }
}
