package ru.job4j.stream;

import org.w3c.dom.ls.LSOutput;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {

    List<Student> collect(List<Student> students, Predicate<Student> predicate) {
        return students;
    }
    public static List<Student> toClass10C(List<Student> students) {
        return students.stream()
                .filter(x -> x.getScore() < 50)
                .collect(Collectors.toList());
    }
    public static List<Student> toClass10B(List<Student> students) {
        return students.stream()
                .filter(x -> x.getScore() >= 50 && x.getScore() < 70)
                .collect(Collectors.toList());
    }
    public static List<Student> toClass10A(List<Student> students) {
        return students.stream()
                .filter(x -> x.getScore() >= 70 && x.getScore() <= 100)
                .collect(Collectors.toList());
    }

}
