package ru.job4j.tracker;

/**
 * Создает меню выбора для различных действий с tracker.
 */
public class StartUI {

    /**
     * Выводит меню с возможностью выбора дальнейших действий по списку.
     * @param input - объект типа Input.
     * @param tracker - объект типа Tracker.
     */
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(input.askStr("Select: "));
            switch (select) {
                case 0:
                    System.out.println("=== Create a new Item ===");
                    String name = input.askStr("Enter the name: ");
                    Item item = new Item(name);
                    tracker.add(item);
                    break;
                case 1:
                    System.out.println("=== List of items ===");
                    Item[] items = tracker.findAll();
                    for (Item x : items) {
                        System.out.println(x);
                    }
                    break;
                case 2:
                    System.out.println("=== Editing the item ===");
                    String id = input.askStr("Enter id for the editing: ");
                    String nameNewItem = input.askStr("Enter the name of new Item: ");
                    Item newItem = new Item(nameNewItem);
                    if (tracker.replace(id, newItem)) {
                        System.out.println("Done!!!");
                    } else {
                        System.out.println("Wrong operation!!!");
                    }
                    break;
                case 3:
                    System.out.println("=== Deleting item ===");
                    String newId = input.askStr("Enter the id of item: ");
                    if (tracker.delete(newId)) {
                        System.out.println("Done!!!");
                    } else {
                        System.out.println("Wrong operation!!!");
                    }
                    break;
                case 4:
                    System.out.println("=== Finding item by id ===");
                    id = input.askStr("Enter id: ");
                    Item byId = tracker.findById(id);
                    if (byId != null) {
                        System.out.println(byId);
                    } else {
                        System.out.println("There is no such id. Wrong operation!!!");
                    }
                    break;
                case 5:
                    System.out.println("=== Finding item by name ===");
                    name = input.askStr("Enter the name of item: ");
                    Item[] itemsByName = tracker.findByName(name);
                    if (itemsByName.length != 0) {
                        for (Item x : itemsByName) {
                            System.out.println(x);
                        }
                    } else {
                        System.out.println("There is no such name. Wrong operation!!!");
                    }
                    break;
                case 6:
                    String answer = input.askStr("Do you really want to exit: (yes/no) ");
                    run = answer.equals("yes") ? false : true;
                    break;
                default:
                    System.out.println("There is no such option.");
            }
        }
    }

    /**
     * Печатает меню выбора.
     */
    private void showMenu() {
        System.out.println(System.lineSeparator() + "Menu.");
        System.out.println("0. Add new item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");

    }

    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Input input = new ConsoleInput();
        new StartUI().init(input, tracker);
    }
}
