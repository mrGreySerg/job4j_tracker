package ru.job4j.tracker;

public class EditAction implements UserAction {

    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println(System.lineSeparator() + "=== Editing the item ===");
        String id = input.askStr("Enter id for the editing: ");
        String nameNewItem = input.askStr("Enter the name of new Item: ");
        Item newItem = new Item(nameNewItem);
        if (tracker.replace(id, newItem)) {
            System.out.println("Done!!!");
        } else {
            System.out.println("Wrong operation!!!");
        }
        return true;
    }
}
