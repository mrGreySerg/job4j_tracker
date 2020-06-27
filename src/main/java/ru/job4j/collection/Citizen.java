package ru.job4j.collection;

import java.util.Objects;

public class Citizen {

    private String passport;
    private String username;

    public Citizen(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    public String getPassport() {
        return this.passport;
    }

    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Citizen citizen = (Citizen) o;
        return Objects.equals(this.passport, citizen.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.passport);
    }

}
