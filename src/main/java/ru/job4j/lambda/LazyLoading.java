package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class LazyLoading {

    public static void main(String[] args) {
        String[] names1 = {
                "Ivan",
        };
        Comparator<String> firstComparator = (left, right) -> {
            System.out.println("Execute comparator 1");
            return left.length() - right.length();
        };
        Arrays.sort(names1, firstComparator);

        String[] names2 = {
                "Ivan",
                "Petr"
        };
        Comparator<String> secondComparator = (left, right) -> {
            System.out.println("Execute comparator 2");
            return left.length() - right.length();
        };
        Arrays.sort(names2, secondComparator);
    }

}
