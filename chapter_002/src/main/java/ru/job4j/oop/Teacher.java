package ru.job4j.oop;

public class Teacher extends Profession {
    Teacher(String name) {
        super(name);
    }
    public Specialist teachStudent(Student student) {
        return new Specialist();
    }
}
