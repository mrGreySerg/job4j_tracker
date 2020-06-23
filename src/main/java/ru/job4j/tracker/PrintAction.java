package ru.job4j.tracker;

import java.util.List;

public class PrintAction implements UserAction {

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println(System.lineSeparator() + "=== List of items ===");
        List<Item> items = tracker.findAll();
        for (Item x : items) {
            System.out.println(x);
        }
        return true;
    }

}
