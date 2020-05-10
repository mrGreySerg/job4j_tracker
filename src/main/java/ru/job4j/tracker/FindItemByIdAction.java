package ru.job4j.tracker;

public class FindItemByIdAction implements UserAction {

    @Override
    public String name() {
        return "Find item by id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println(System.lineSeparator() + "=== Finding item by id ===");
        String id = input.askStr("Enter id: ");
        Item byId = tracker.findById(id);
        if (byId != null) {
            System.out.println(byId);
        } else {
            System.out.println("There is no such id. Wrong operation!!!");
        }
        return true;
    }
}
