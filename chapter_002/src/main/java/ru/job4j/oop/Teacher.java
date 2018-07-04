package ru.job4j.oop;

public class Teacher extends Profession {
    public Specialist teachStudent(Student student) {
        return new Specialist();
    }
}
