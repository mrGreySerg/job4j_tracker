package ru.job4j.collection;

import java.util.Arrays;
import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        return Integer.compare(parseStrToInt(left), parseStrToInt(right));
    }

    private int parseStrToInt(String str) {
        String[] arrayString = str.split("\\.");
        int result = Integer.parseInt(arrayString[0]);
        return result;
    }

}
