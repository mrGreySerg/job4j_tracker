package ru.job4j.bank;

import java.util.Objects;

/**
 * Модель пользователя банком.
 * @author Kustrin Sergei.
 * @version 1.0.
 */
public class User {

    /**
     * Номер пасспорта.
     */
    private String passport;
    /**
     * Имя пользователя.
     */
    private String userName;

    public User(String passport, String userName) {
        this.passport = passport;
        this.userName = userName;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(this.passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.passport);
    }

}
