package de.jetrom.app.java17.record;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonExtendedTest {

    public static final String NAME = "Wonderland";
    public static final String FIRSTNAME = "Alice";
    public static final LocalDate BIRTHDAY = LocalDate.parse("1999-01-10");
    public static final String CITY = "London";
    private PersonExtended person;

    @BeforeEach
    public void setup() {
        person = new PersonExtended(NAME, FIRSTNAME, BIRTHDAY, CITY);
    }

    @Test
    void testToString() {
        var personString = String.format(PersonExtended.PERSON_EXTENDED_STRING, NAME, FIRSTNAME, BIRTHDAY, CITY);

        assertEquals(personString, person.toString());
    }

    @Test
    void cityUpperCase() {
        assertEquals(CITY.toUpperCase(), person.cityUpperCase());
    }
}