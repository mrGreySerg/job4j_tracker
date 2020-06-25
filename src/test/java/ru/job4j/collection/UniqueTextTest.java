package ru.job4j.collection;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class UniqueTextTest {

    @Test
    public void isEquals() {
        String origin = "My cat eats a mouse";
        String text = "My cat eats a mouse";
        boolean expected = true;
        boolean result = UniqueText.isEquals(origin, text);
        assertThat(result, is(expected));
    }

    @Test
    public void isNotEquals() {
        String origin = "My cat eats a mouse";
        String text = "A mouse is eaten by a cat";
        boolean expected = false;
        boolean result = UniqueText.isEquals(origin, text);
        assertThat(result, is(expected));
    }

}