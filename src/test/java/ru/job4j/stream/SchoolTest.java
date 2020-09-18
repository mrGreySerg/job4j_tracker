package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class SchoolTest {

    @Test
    public void whenToClass10A() {
        List<Student> students = List.of(
                new Student(70, "Anton"),
                new Student(20, "Kirill"),
                new Student(90, "Artem"),
                new Student(65, "Sergei"),
                new Student(55, "Jon")
        );
        List<Student> expected = List.of(
                new Student(70, "Anton"),
                new Student(90, "Artem")
        );
        School newSchool = new School();
        List<Student> result = newSchool.collect(students, x -> x.getScore() >= 70);
        assertThat(result, is(expected));
    }

    @Test
    public void whenToClass10B() {
        List<Student> students = List.of(
                new Student(70, "Anton"),
                new Student(20, "Kirill"),
                new Student(90, "Artem"),
                new Student(65, "Sergei"),
                new Student(55, "Jon")
        );
        List<Student> expected = List.of(
                new Student(65, "Sergei"),
                new Student(55, "Jon")
        );
        School newSchool = new School();
        List<Student> result = newSchool.collect(students,
                x -> x.getScore() >= 50
                && x.getScore() < 70
        );
        assertThat(result, is(expected));
    }

    @Test
    public void whenToClass10C() {
        List<Student> students = List.of(
                new Student(70, "Anton"),
                new Student(20, "Kirill"),
                new Student(90, "Artem"),
                new Student(65, "Sergei"),
                new Student(55, "Jon")
        );
        List<Student> expected = List.of(
                new Student(20, "Kirill")
        );
        School newSchool = new School();
        List<Student> result = newSchool.collect(students,
                x -> x.getScore() < 50
        );
        assertThat(result, is(expected));
    }

}