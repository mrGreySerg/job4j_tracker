package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {

    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    private boolean isExist(String key, Person person) {
        boolean result = false;
        if (person.getName().contains(key)
                || person.getSurname().contains(key)
                || person.getPhone().contains(key)
                || person.getAddress().contains(key)) {
            result = true;
        }
        return result;
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<Person>();
        for (Person person : this.persons) {
            if (isExist(key, person)) {
                result.add(person);
            }
        }
        return result;
    }

    public ArrayList<Person> findAnother(String key) {
        Predicate<Person> combine = x -> {
            if (x.getName().contains(key)
                    || x.getSurname().contains(key)
                    || x.getAddress().contains(key)
                    || x.getPhone().contains(key)) {
                return true;
            }
            return false;
        };
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : this.persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }

}