package de.jetrom.app.java17.record;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    public static final String NAME = "Miller";
    public static final String FIRSTNAME = "Peter";
    public static final LocalDate BIRTHDAY = LocalDate.parse("2000-12-01");

    @Test
    public void createRecordPerson() {
        var person = new Person(NAME, FIRSTNAME, BIRTHDAY);

        assertEquals(NAME, person.name());
        assertEquals(FIRSTNAME, person.firstname());
        assertEquals(BIRTHDAY, person.birthday());

    }

}