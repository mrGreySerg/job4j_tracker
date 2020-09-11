package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class FuncInDiapasonTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> list = FuncInDiapason.diapason(5, 8, x -> x * 2 + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(list, is(expected));
    }

    @Test
    public void whenQuadraticFunction() {
        List<Double> list = FuncInDiapason.diapason(2, 5, x -> Math.pow(x, 2) + 3);
        List<Double> expected = Arrays.asList(7D, 12D, 19D);
        assertThat(list, is(expected));
    }

    @Test
    public void whenExponentialFunction() {
        List<Double> list = FuncInDiapason.diapason(1, 4, x -> Math.pow(3, x));
        List<Double> expected = Arrays.asList(3D, 9D, 27D);
        assertThat(list, is(expected));
    }

}