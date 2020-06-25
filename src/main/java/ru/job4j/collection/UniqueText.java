package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {

    public static boolean isEquals(String originText, String duplicateText) {
        boolean result = true;
        String[] origin = originText.split(" ");
        String[] duplicate = duplicateText.split(" ");
        HashSet<String> check = new HashSet<String>();
        for (String word : origin) {
            check.add(word);
        }
        for (String word : duplicate) {
            if (!check.contains(word)) {
                result = false;
                break;
            }
        }
        return result;
    }

}
