package ru.job4j.oop;

public class Doctor extends Profession {
    Doctor (String name) {
        super(name);
    }
    public Diagnosis healPatient(Patient patient) {
        return new Diagnosis();
    }
}
