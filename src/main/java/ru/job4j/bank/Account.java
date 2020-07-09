package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель банковского счета Аккаунт.
 * @author Kustrin Sergei.
 * @version 1.0.
 */
public class Account {

    /**
     * Реквизиты счета.
     */
    private String requisite;
    /**
     * Баланс счета.
     */
    private double balance;

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    public String getRequisite() {
        return this.requisite;
    }

    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(this.requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.requisite);
    }

}
