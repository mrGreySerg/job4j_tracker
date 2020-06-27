package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {

    public static void main(String[] args) {
        HashMap<String, String> accounts = new HashMap<>();
        accounts.put("person@mail.ru", "Sergei Nikolaevich Kustrin");
        for (String key : accounts.keySet()) {
            String value = accounts.get(key);
            System.out.println(key + " = " + value);
        }
    }

}
