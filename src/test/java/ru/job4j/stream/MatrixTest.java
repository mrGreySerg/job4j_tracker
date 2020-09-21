package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class MatrixTest {

    @Test
    public void whenCheckMatrixToList() {
        Integer[][] matrixOfInteger = {
                {1, 3, 5},
                {6, 7, 10}
        };
        List<Integer> expected = List.of(
                1, 3, 5, 6, 7, 10
        );

        List<Integer> result = Matrix.matrixToList(matrixOfInteger);
        assertThat(result, is(expected));
    }

}