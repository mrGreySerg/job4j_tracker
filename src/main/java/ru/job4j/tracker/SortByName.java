package ru.job4j.tracker;

import java.util.Comparator;

/**
 * Сортировка по возрастанию.
 */
public class SortByName implements Comparator<Item> {

    @Override
    public int compare(Item first, Item second) {
        return first.getName().compareTo(second.getName());
    }

}
