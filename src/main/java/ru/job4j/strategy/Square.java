package ru.job4j.strategy;

import java.util.StringJoiner;

public class Square implements Shape {

    @Override
    public String draw() {
        StringJoiner square = new StringJoiner(System.lineSeparator());
        for (int index = 0; index < 3; index++) {
            square.add("[][][]");
        }
        return square.toString();
    }
}