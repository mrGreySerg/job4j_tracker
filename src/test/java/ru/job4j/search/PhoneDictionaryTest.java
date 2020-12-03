package ru.job4j.search;

import java.util.ArrayList;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PhoneDictionaryTest {

    @Test
    public void whenContainsArsentev() {
        var petr = new Person("Petr", "Arsentev", "534872", "Bryansk");
        var phones = new PhoneDictionary();
        phones.add(petr);
        var result = phones.find("Petr");
        var expected = "Arsentev";
        assertThat(result.get(0).getSurname(), is(expected));
    }

    @Test
    public void whenFindByName() {
        var phones = new PhoneDictionary();
        phones.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        var persons = phones.findAnother("Petr");
        assertThat(persons.get(0).getSurname(), is("Arsentev"));
    }

}