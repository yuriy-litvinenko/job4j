package ru.job4j.listtomap;

import org.junit.Test;
import ru.job4j.filtration.Student;

import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StudentsTest {
    @Test
    public void convertStudentsListToMap() {
        Student student1 = new Student("Ivanov");
        Student student2 = new Student("Petrov");
        Student student3 = new Student("Sidorov");
        List<Student> studentsList = List.of(student1, student2, student3);
        Map<String, Student> result = new Students().listToMap(studentsList);
        Map<String, Student> expect = Map.of("Ivanov", student1, "Petrov", student2, "Sidorov", student3);
        assertThat(result, is(expect));
    }
}
