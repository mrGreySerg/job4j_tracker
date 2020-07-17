package ru.job4j.collection;

import java.util.Comparator;

/**
 * Компаратор для сортировки по имени по возрастанию.
 */
public class JobDescByNameIncrease implements Comparator<Job> {

    @Override
    public int compare(Job first, Job second) {
        return first.getName().compareTo(second.getName());
    }

}
