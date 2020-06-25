package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;
import java.util.Arrays;
import java.util.Set;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class FullSearchTest {

    @Test
    public void whenAdd1231Then123() {
        List<Task> tasks = Arrays.asList(
                new Task("1", "First desc"),
                new Task("2", "Second desc"),
                new Task("1", "Third desc")
        );
        Set<String> resultSet = FullSearch.extractNumber(tasks);
        Set<String> expected = new HashSet<>(Arrays.asList("1", "2", "3"));
        assertThat(resultSet, is(expected));
    }

}