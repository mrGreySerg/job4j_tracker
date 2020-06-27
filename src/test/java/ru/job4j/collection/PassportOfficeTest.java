package ru.job4j.collection;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class PassportOfficeTest {

    @Test
    public void whenAddNewCitizen() {
        Citizen citizen = new Citizen("123456", "Kustrin Sergei");
        PassportOffice passportOffice = new PassportOffice();
        passportOffice.add(citizen);
        Citizen expected = citizen;
        Citizen result = passportOffice.get(citizen.getPassport());
        assertThat(result, is(expected));
    }

    @Test
    public void whenCitizenExist() {
        Citizen newCitizen = new Citizen("123456", "Ivanov Ivan");
        PassportOffice office = new PassportOffice();
        office.add(new Citizen("1122", "Kustrin Sergei"));
        office.add(new Citizen("123456", "Ivanov Ivan"));
        boolean result = office.add(newCitizen);
        boolean expected = false;
        assertThat(result, is(expected));
    }

}