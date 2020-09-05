package ru.job4j.collection;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

public class DepIncreaseCompTest {

    @Test
    public void firstTest() {
        int result = new DepIncreaseComp().compare(
                "K1", "K1/SK1"
        );
        assertThat(result, lessThan(0));
    }

    @Test
    public void secondIsLess() {
        int result = new DepIncreaseComp().compare("K2", "K1");
        assertThat(result, greaterThan(0));
    }

}