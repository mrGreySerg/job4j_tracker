package ru.job4j.collection;

import java.util.Comparator;

/**
 * Компаратор для сортировки по имени по убыванию.
 */
public class JobDescByNameDecrease implements Comparator<Job> {

    @Override
    public int compare(Job first, Job second) {
        return second.getName().compareTo(first.getName());
    }

}
