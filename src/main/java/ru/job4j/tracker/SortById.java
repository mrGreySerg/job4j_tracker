package ru.job4j.tracker;

import java.util.Comparator;

/**
 * Сортировка по убыванию.
 */
public class SortById implements Comparator<Item> {

    @Override
    public int compare(Item first, Item second) {
        return second.getId().compareTo(first.getId());
    }

}
