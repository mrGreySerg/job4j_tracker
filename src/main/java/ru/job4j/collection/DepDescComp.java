package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {

    @Override
    public int compare(String first, String second) {
        int result = second.substring(0, 2).compareTo(first.substring(0, 2));
        if (result == 0) {
            return first.compareTo(second);
        }
        return result;
    }

}
