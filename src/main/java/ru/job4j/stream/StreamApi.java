package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApi {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = -10; i <= 10; i++) {
            list.add(i);
        }
        list.stream()
                .filter(x -> x > 0)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

}
