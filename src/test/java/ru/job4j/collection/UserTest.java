package ru.job4j.collection;

import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserTest {

    @Test
    public void whenAsc() {
        Set<User> users = new TreeSet<>();
        users.add(new User("Petr", 32));
        users.add(new User("Ivan", 31));
        Iterator<User> it = users.iterator();
        assertThat(it.next(), is(new User("Ivan", 31)));
        assertThat(it.next(), is(new User("Petr", 32)));
        }

    @Test
    public void whenComparePetrUsIvan() {
        int result = new User("Petr", 32)
                .compareTo(new User("Ivan", 31));
        assertThat(result, greaterThan(0));
    }

    @Test
    public void whenComparePetrUsPert() {
        int result = new User("Petr", 32)
                .compareTo(new User("Petr", 35));
        assertThat(result, lessThan(0));
    }

}

