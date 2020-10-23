package ru.job4j.listtomap;

import ru.job4j.filtration.Student;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Students {
    Map<String, Student> listToMap(List<Student> students) {
        return students.stream().collect(Collectors.toMap(Student::getLastName, s -> s));
    }
}
