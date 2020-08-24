package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class StringCompareTest {

    @Test
    public void whenStringsAreEqualsThenZero() {
        StringCompare stringCompare = new StringCompare();
        String first = "Ivanov";
        String second = "Ivanov";
        int result = stringCompare.compare(first, second);
        int expected = 0;
        assertThat(result, is(expected));
    }

    @Test
    public void whenLeftLessThanRightResultShouldBeNegative() {
        StringCompare stringCompare = new StringCompare();
        String first = "Ivanov";
        String second = "Ivanova";
        int result = stringCompare.compare(first, second);
        assertThat(result, lessThan(0));
    }

    @Test
    public void whenLeftGreaterThanRightShouldBePositive() {
        StringCompare stringCompare = new StringCompare();
        String first = "Petrov";
        String second = "Ivanova";
        int result = stringCompare.compare(first, second);
        assertThat(result, greaterThan(0));
    }

    @Test
    public void secondCharOfLeftGreaterThanRightShouldBePositive() {
        StringCompare stringCompare = new StringCompare();
        String first = "Petrov";
        String second = "Patrov";
        int result = stringCompare.compare(first, second);
        assertThat(result, greaterThan(0));
    }

    @Test
    public void secondCharOfLeftLessThanRightShouldBeNegative() {
        StringCompare stringCompare = new StringCompare();
        String first = "Patrova";
        String second = "Petrov";
        int result = stringCompare.compare(first, second);
        assertThat(result, lessThan(0));
    }

    @Test
    public void whenFirstIsLonger() {
        StringCompare stringCompare = new StringCompare();
        String first = "Ivanova";
        String second = "Ivanov";
        int result = stringCompare.compare(first, second);
        int expected = 0;
        assertThat(result, greaterThan(0));
    }

}