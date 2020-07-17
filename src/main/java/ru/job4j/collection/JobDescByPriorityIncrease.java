package ru.job4j.collection;

import java.util.Comparator;

/**
 * Компаратор для сортировки по приоритету по возрастанию.
 */
public class JobDescByPriorityIncrease implements Comparator<Job> {

    @Override
    public int compare(Job first, Job second) {
        return Integer.compare(first.getPriority(), second.getPriority());
    }

}
