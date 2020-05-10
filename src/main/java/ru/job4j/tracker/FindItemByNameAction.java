package ru.job4j.tracker;

public class FindItemByNameAction implements UserAction {
    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println(System.lineSeparator() + "=== Finding item by name ===");
        String name = input.askStr("Enter the name of item: ");
        Item[] itemsByName = tracker.findByName(name);
        if (itemsByName.length != 0) {
            for (Item x : itemsByName) {
                System.out.println(x);
            }
        } else {
            System.out.println("There is no such name. Wrong operation!!!");
        }
        return true;
    }
}
