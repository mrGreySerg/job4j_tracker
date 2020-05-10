package ru.job4j.tracker;

public class CreateAction implements UserAction {

    @Override
    public String name() {
        return "Add new item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println(System.lineSeparator() + "=== Create a new Item ===");
        String name = input.askStr("Enter the name: ");
        Item item = new Item(name);
        tracker.add(item);
        return true;
    }
}
