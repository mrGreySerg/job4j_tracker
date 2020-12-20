package ru.job4j.bank;

import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class BankServiceTest {

    @Test
    public void addUser() {
        User user = new User("123456", "Kustrin Sergei");
        BankService bank = new BankService();
        bank.addUser(user);
        assertThat(bank.findByPassport("123456").get(), is(user));
    }

    @Test
    public void whenEnterInvalidPassport() {
        User user = new User("123456", "Kustrin Sergei");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 140D));
        assertThat(bank.findByRequisite("654321", "5546").isEmpty(), is(true));
    }

    @Test
    public void addAccount() {
        User user = new User("123456", "Kustrin Sergei");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 140D));
        assertThat(bank.findByRequisite("123456", "5546").get().getBalance(), is(140D));
    }

    @Test
    public void transferMoney() {
        User user = new User("123456", "Kustrin Sergei");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 140D));
        bank.addAccount(user.getPassport(), new Account("113", 40D));
        bank.transferMoney(user.getPassport(), "5546",
                user.getPassport(), "113", 140D);
        assertThat(bank.findByRequisite(user.getPassport(), "113").get().getBalance(), is(180D));
    }

}