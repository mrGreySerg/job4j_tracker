package ru.job4j.tracker;

import java.util.Scanner;

/**
 * Создает меню выбора для различных действий с tracker.
 */
public class StartUI {

    /**
     * Выводит меню с возможностью выбора дальнейших действий по списку.
     * @param scanner - объект типа Scanner.
     * @param tracker - объект типа Tracker.
     */
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            switch (select) {
                case 0:
                    System.out.println("=== Create a new Item ===");
                    System.out.print("Enter the name: ");
                    String name = scanner.nextLine();
                    Item item = new Item(name);
                    tracker.add(item);
                    break;
                case 1:
                    System.out.println("=== List of items ===");
                    Item[] items = tracker.findAll();
                    for (Item x : items) {
                        System.out.print("Имя позиции: " + x.getName() + "; ");
                        System.out.println("id: " + x.getId() + ".");
                    }
                    break;
                case 2:
                    System.out.println("=== Editing the item ===");
                    System.out.print("Enter id for the editing: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter the name of new Item: ");
                    String nameNewItem = scanner.nextLine();
                    Item newItem = new Item(nameNewItem);
                    if (tracker.replace(id, newItem)) {
                    System.out.println("Done!!!");
                    } else {
                    System.out.println("Wrong operation!!!");
                    }
                    break;
                case 3:
                    System.out.println("=== Deleting item ===");
                    System.out.print("Enter the id of item: ");
                    String newId = scanner.nextLine();
                    if (tracker.delete(newId)) {
                        System.out.println("Done!!!");
                    } else {
                        System.out.println("Wrong operation!!!");
                    }
                    break;
                case 4:
                    System.out.println("=== Finding item by id ===");
                    System.out.print("Enter id: ");
                    id = scanner.nextLine();
                    Item byId = tracker.findById(id);
                    System.out.print("Имя позиции: " + byId.getName() + "; ");
                    System.out.println("id :" + byId.getId() + ".");
                    break;
                case 5:
                    System.out.println("=== Finding item by name ===");
                    System.out.print("Enter the name of item: ");
                    name = scanner.nextLine();
                    Item[] itemsByName = tracker.findByName(name);
                    for (Item x : itemsByName) {
                        System.out.print("Имя позиции: " + x.getName() + "; ");
                        System.out.println("id :" + x.getId() + ".");
                    }
                    break;
                case 6:
                    System.out.println("Do you really want to exit: (yes/no) ");
                    String answer = scanner.nextLine();
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
        System.out.println("\nMenu.");
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
        Scanner scanner = new Scanner(System.in);
        new StartUI().init(scanner, tracker);
    }
}
