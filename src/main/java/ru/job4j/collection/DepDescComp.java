package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {

    @Override
    public int compare(String first, String second) {
        if (first.substring(0, 2).equals(second.substring(0, 2))) {
            return first.substring(2).compareTo(second.substring(2));
        }
        return second.compareTo(first);
    }
}
