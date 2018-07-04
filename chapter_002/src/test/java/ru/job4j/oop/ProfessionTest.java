package ru.job4j.oop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfessionTest {
    @Test
    public void getNameForDoctorClass() {
        Doctor doctor = new Doctor("House");
        String result = doctor.getName();
        String expect = "House";
        assertThat(result, is(expect));
    }

    @Test
    public void getNameForEngeneerClass() {
        Engineer engineer = new Engineer("Steve Jobs");
        String result = engineer.getName();
        String expect = "Steve Jobs";
        assertThat(result, is(expect));
    }

    @Test
    public void getNameForTeacherClass() {
        Teacher teacher = new Teacher("Nestor Petrovich");
        String result = teacher.getName();
        String expect = "Nestor Petrovich";
        assertThat(result, is(expect));
    }
}
