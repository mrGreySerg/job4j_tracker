package ru.job4j.tracker;

public class DeleteAction implements UserAction {

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println(System.lineSeparator() + "=== Deleting item ===");
        String newId = input.askStr("Enter the id of item: ");
        if (tracker.delete(newId)) {
            System.out.println("Done!!!");
        } else {
            System.out.println("Wrong operation!!!");
        }
        return true;
    }
}
