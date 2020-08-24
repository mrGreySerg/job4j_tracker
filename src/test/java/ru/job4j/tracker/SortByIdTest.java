package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class SortByIdTest {

    @Test
    public void whenSortByLoweringId() {
        Item first = new Item("Sergei");
        first.setId("10");
        Item second = new Item("Igor");
        second.setId("11");
        Item third = new Item("Artem");
        third.setId("12");
        List<Item> items = Arrays.asList(second, third, first);
        Collections.sort(items, new SortById());
        List<Item> expected = Arrays.asList(third, second, first);
        assertThat(items, is(expected));
    }

    @Test
    public void whenSortByIncreaseId() {
        Item first = new Item("Sergei");
        first.setId("10");
        Item second = new Item("Igor");
        second.setId("11");
        Item third = new Item("Artem");
        third.setId("12");
        List<Item> items = Arrays.asList(second, third, first);
        Collections.sort(items, new SortById().reversed());
        List<Item> expected = Arrays.asList(first, second, third);
        assertThat(items, is(expected));
    }

}