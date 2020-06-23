package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.StringJoiner;

import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class StartUITest {

    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        UserAction createAction = new CreateAction();
        createAction.execute(input, tracker);
        Item created = tracker.findAll().get(0);
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new Item");
        tracker.add(item);
        String[] answers = {item.getId(), "replaced item"};
        UserAction editAction = new EditAction();
        editAction.execute(new StubInput(answers), tracker);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("replaced item"));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new Item");
        tracker.add(item);
        String[] answers = {item.getId()};
        UserAction deleteAction = new DeleteAction();
        deleteAction.execute(new StubInput(answers), tracker);
        Item deleted = tracker.findById(item.getId());
        assertThat(deleted, is(nullValue()));
    }

    @Test
    public void whenExit() {
        StubInput input = new StubInput(new String[] {"0"});
        StubAction action = new StubAction();
        new StartUI().init(input, new Tracker(), List.of(action));
        assertThat(action.isCall(), is(true));
    }

    @Test
    public void whenPrtMenu() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        StubInput input = new StubInput(new String[] {"0"});
        StubAction action = new StubAction();
        new StartUI().init(input, new Tracker(), List.of(action));
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add(System.lineSeparator() +"Menu.")
                .add("0. Stub action")
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }

}