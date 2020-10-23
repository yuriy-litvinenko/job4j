package ru.job4j.filtration;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {
    @Test
    public void getClassAStudentsListWithScoreBetween70And100() {
        Student student1 = new Student(10);
        Student student2 = new Student(20);
        Student student3 = new Student(30);
        Student student4 = new Student(40);
        Student student5 = new Student(50);
        Student student6 = new Student(60);
        Student student7 = new Student(70);
        Student student8 = new Student(80);
        Student student9 = new Student(90);
        List<Student> studentsList = List.of(student1, student2, student3, student4, student5, student6, student7, student8, student9);
        School school = new School();
        List<Student> result = school.collect(studentsList, s -> (s.getScore() >= 70) && (s.getScore() <= 100));
        List<Student> expect = List.of(student7, student8, student9);
        assertThat(result, is(expect));
    }

    @Test
    public void getClassBStudentsListWithScoreBetween50And70() {
        Student student1 = new Student(10);
        Student student2 = new Student(20);
        Student student3 = new Student(30);
        Student student4 = new Student(40);
        Student student5 = new Student(50);
        Student student6 = new Student(60);
        Student student7 = new Student(70);
        Student student8 = new Student(80);
        Student student9 = new Student(90);
        List<Student> studentsList = List.of(student1, student2, student3, student4, student5, student6, student7, student8, student9);
        School school = new School();
        List<Student> result = school.collect(studentsList, s -> (s.getScore() >= 50) && (s.getScore() < 70));
        List<Student> expect = List.of(student5, student6);
        assertThat(result, is(expect));
    }

    @Test
    public void getClassCStudentsListWithScoreBetween0And50() {
        Student student1 = new Student(10);
        Student student2 = new Student(20);
        Student student3 = new Student(30);
        Student student4 = new Student(40);
        Student student5 = new Student(50);
        Student student6 = new Student(60);
        Student student7 = new Student(70);
        Student student8 = new Student(80);
        Student student9 = new Student(90);
        List<Student> studentsList = List.of(student1, student2, student3, student4, student5, student6, student7, student8, student9);
        School school = new School();
        List<Student> result = school.collect(studentsList, s -> (s.getScore() >= 0) && (s.getScore() < 50));
        List<Student> expect = List.of(student1, student2, student3, student4);
        assertThat(result, is(expect));
    }
}
