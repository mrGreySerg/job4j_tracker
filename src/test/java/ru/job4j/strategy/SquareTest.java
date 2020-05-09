package ru.job4j.strategy;

import org.junit.Test;

import java.util.StringJoiner;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class SquareTest {

    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        String result = square.draw();
        assertThat(result, is(new StringJoiner(System.lineSeparator())
                        .add("[][][]")
                        .add("[][][]")
                        .add("[][][]")
                        .toString()
                )
        );
    }
}