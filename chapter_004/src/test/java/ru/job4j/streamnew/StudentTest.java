package ru.job4j.streamnew;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StudentTest {
    @Test
    public void getStudentsListWhereScopeGreaterThenBound() {
        Student student1 = new Student("Квятковский Нестор Егорович", 54);
        Student student2 = new Student("Мячикова Анисья Казимировна", 17);
        Student student3 = new Student("Мещерякова Варвара Якововна", 9);
        Student student4 = new Student("Смольников Тимофей Куприянович", 87);
        Student student5 = new Student("Бабичев Семён Иннокентиевич", 41);
        Student student6 = new Student("Окладников Изяслав Потапович", 52);
        Student student7 = new Student("Харламов Никифор Евлампиевич", 23);
        Student student8 = new Student("Бруевича Татьяна Всеволодовна", 57);
        Student student9 = new Student("Сиянгулова Лилия Афанасиевна", 10);
        Student student10 = new Student("Дубинкин Поликарп Леонович", 16);
        List<Student> studentList = new ArrayList<>(Arrays.asList(student1, null, student2, student3, student4, null, student5, student6, student7, null, student8, student9, student10));
        List<Student> result = new Students().levelOf(studentList, 50);
        List<Student> expect = List.of(student4, student8, student1, student6);
        assertThat(result, is(expect));
    }
}
