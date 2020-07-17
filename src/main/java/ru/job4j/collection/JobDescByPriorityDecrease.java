package ru.job4j.collection;

import java.util.Comparator;

/**
 * Компаратор для сортировки по приоритету по убыванию.
 */
public class JobDescByPriorityDecrease implements Comparator<Job> {

    @Override
    public int compare(Job first, Job second) {
        return Integer.compare(second.getPriority(), first.getPriority());
    }

}
