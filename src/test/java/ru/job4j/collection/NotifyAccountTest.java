package ru.job4j.collection;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class NotifyAccountTest {

    @Test
    public void sent() {
        List<Account> accounts = List.of(
                new Account("123", "Petr Arsentev", "12345"),
                new Account("456", "Petr Arsentev", "121212")
        );
        HashSet<Account> expected = new HashSet<Account>(List.of(
                new Account("123", "Petr Arsentev", "12345"),
                new Account("456", "Petr Arsentev", "121212")
            )
        );
        HashSet<Account> result = NotifyAccount.sent(accounts);
        assertThat(result, is(expected));
    }

    @Test
    public void when2AccountsEquals() {
        List<Account> accounts = List.of(
                new Account("12345", "Sergei Kustrin", "dep1"),
                new Account("123567", "Sergei Kustrin", "dep2"),
                new Account("12345", "Sergei Kustrin", "dep1")
        );
        HashSet<Account> expected = new HashSet<>(List.of(
                new Account("12345", "Sergei Kustrin", "dep1"),
                new Account("123567", "Sergei Kustrin", "dep2")
            )
        );
        HashSet<Account> result = NotifyAccount.sent(accounts);
        assertThat(result, is(expected));
    }

}