package ru.job4j.stream;

import java.util.Objects;

public class Address {

    private String city;
    private String street;
    private int home;
    private int apartment;

    public String getCity() {
        return this.city;
    }

    @Override
    public boolean equals(Object another) {
        if (this == another) {
            return true;
        }
        if (another == null || this.getClass() != another.getClass()) {
            return false;
        }
        Address address = (Address) another;
        return this.city.equals(address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city);
    }

}
