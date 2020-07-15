package ru.job4j.collection;

import java.util.Objects;

public class User implements Comparable<User> {

    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(User user) {
        if (this.name == user.name) {
            return Integer.compare(this.age, user.age);
        }
        return this.name.compareTo(user.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return this.age == user.age && Objects.equals(this.name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.age);
    }

}
