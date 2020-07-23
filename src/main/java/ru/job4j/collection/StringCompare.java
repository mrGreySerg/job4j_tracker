package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int compareChar = 0;
        int minLength = Math.min(left.length(), right.length());
        for (int index = 0; index < minLength; index++) {
            char a = left.charAt(index);
            char b = right.charAt(index);
            compareChar = Character.compare(a, b);
            if (compareChar != 0) {
                break;
            }
        }
        if (compareChar == 0) {
            compareChar = Integer.compare(left.length(), right.length());
        }
        return compareChar;
    }

}

