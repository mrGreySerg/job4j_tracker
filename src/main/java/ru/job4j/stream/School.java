package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {

    List<Student> collect(List<Student> students, Predicate<Student> predicate) {
        return students.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public Map<String, Student> mapForStudent(List<Student> listOfStudents) {
        return listOfStudents.stream().collect(Collectors.toMap(
                student -> student.getSurname(),
                student -> student
        ));
    }

}
