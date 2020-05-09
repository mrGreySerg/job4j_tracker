package ru.job4j.strategy;

import java.util.StringJoiner;

public class Triangle implements Shape {

    @Override
    public String draw() {
        StringJoiner triangle = new StringJoiner(System.lineSeparator());
        triangle.add("  *  ");
        triangle.add(" *** ");
        triangle.add("*****");
        return triangle.toString();
    }
}
