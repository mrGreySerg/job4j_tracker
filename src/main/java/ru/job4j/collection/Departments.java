package ru.job4j.collection;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        HashSet<String> tmp = new HashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                tmp.add(start + el);
                start += el + "/";
            }
        }
        List<String> newList = new ArrayList<>(tmp);
        Departments.sortAsc(newList);
        return newList;
    }

    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs, new DepIncreaseComp());
    }

    public static void sortDesc(List<String> orgs) {
        Collections.sort(orgs, new DepDescComp());
    }

}
