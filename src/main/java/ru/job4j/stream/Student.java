package ru.job4j.stream;

import java.util.Objects;

public class Student {

    private int score;
    private String surname;

    public Student(int score, String surname) {
        this.score = score;
        this.surname = surname;
    }

    public int getScore() {
        return this.score;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return this.score == student.score
                && this.surname.equals(student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.score, this.surname);
    }

}
