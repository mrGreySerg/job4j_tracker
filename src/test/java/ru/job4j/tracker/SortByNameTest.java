package ru.job4j.tracker;

import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Arrays;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class SortByNameTest {

    @Test
    public void whenSortByIncreaseName() {
        Item first = new Item("Sergei");
        Item second = new Item("Igor");
        Item third = new Item("Artem");
        List<Item> items = Arrays.asList(
                second, first, third
        );
        Collections.sort(items, new SortByName());
        List<Item> expected = Arrays.asList(third, second, first);
        assertThat(items, is(expected));
    }

    @Test
    public void whenSortByLoweringName() {
        Item first = new Item("Sergei");
        Item second = new Item("Igor");
        Item third = new Item("Artem");
        List<Item> items = Arrays.asList(
                second, first, third
        );
        Collections.sort(items, new SortByName().reversed());
        List<Item> expected = Arrays.asList(first, second, third);
        assertThat(items, is(expected));
    }

}