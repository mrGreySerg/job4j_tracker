package ru.job4j.collection;

import java.util.Comparator;

public class DepIncreaseComp implements Comparator<String> {

    @Override
    public int compare(String first, String second) {
        return first.compareTo(second);
    }

}
