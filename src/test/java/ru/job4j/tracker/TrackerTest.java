package ru.job4j.tracker;

import java.util.List;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;

public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenFindAllThreeElem() {
        Tracker tracker = new Tracker();
        Item one = new Item("one");
        Item two = new Item("two");
        Item three = new Item("three");
        tracker.add(one);
        tracker.add(two);
        tracker.add(three);
        List<Item> result = tracker.findAll();
        int expect = 3;
        assertThat(result.size(), is(expect));
    }

    @Test
    public void whenFindByNameTwo() {
        Tracker tracker = new Tracker();
        Item one = new Item("one");
        Item two = new Item("two");
        Item three = new Item("three");
        tracker.add(one);
        tracker.add(two);
        tracker.add(three);
        String expect = "two";
        List<Item> found = tracker.findByName("two");
        String result = found.get(0).getName();
        assertThat(result, is(expect));
        assertThat(found.size(), is(1));
    }

    @Test
    public void whenFindByIdTrue() {
        Tracker tracker = new Tracker();
        Item one = new Item("one");
        Item two = new Item("two");
        Item three = new Item("three");
        tracker.add(one);
        tracker.add(two);
        tracker.add(three);
        Item result = tracker.findById(two.getId());
        assertThat(result.getId(), is(two.getId()));
    }

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item bug = new Item("bug");
        tracker.add(bug);
        String id = bug.getId();
        Item bugWithDesc = new Item("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item bug = new Item("Bug");
        tracker.add(bug);
        String id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }

}