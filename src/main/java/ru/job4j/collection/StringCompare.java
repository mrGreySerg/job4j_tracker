package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int compareChar = 0;
        for (int index = 0; index < left.length(); index++) {
            char a = left.charAt(index);
            char b = right.charAt(index);
            compareChar = Character.compare(a, b);
            if (compareChar != 0) {
                break;
            } else if (index == right.length() - 1
                    && left.length() > right.length()) {
                compareChar = 1;
                break;
            }
        }
        if (compareChar == 0 && left.length() < right.length()) {
            compareChar = -1;
        }
        return compareChar;
    }

}
