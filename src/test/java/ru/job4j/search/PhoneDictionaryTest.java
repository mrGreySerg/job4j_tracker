package ru.job4j.search;

import java.util.ArrayList;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PhoneDictionaryTest {

    @Test
    public void whenContainsArsentev() {
        Person petr = new Person("Petr", "Arsentev", "534872", "Bryansk");
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(petr);
        ArrayList<Person> result = phones.find("Petr");
        String expected = "Arsentev";
        assertThat(result.get(0).getSurname(), is(expected));
    }

}