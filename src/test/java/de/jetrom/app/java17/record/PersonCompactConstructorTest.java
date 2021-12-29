package de.jetrom.app.java17.record;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static de.jetrom.app.java17.record.PersonConstructorValidator.EXCEPTION_MESSAGE_FOR_INVALID_PARAMETERS;
import static org.junit.jupiter.api.Assertions.*;

class PersonCompactConstructorTest {

    public static final String NAME = "Wonderland";
    public static final String FIRSTNAME = "Alice";
    public static final LocalDate BIRTHDAY = LocalDate.parse("1999-01-10");

    @Test
    public void createRecordPersonWithValidArguments() {
        var person = new PersonCompactConstructor(NAME, FIRSTNAME, BIRTHDAY);

        assertEquals(NAME, person.name());
        assertEquals(FIRSTNAME, person.firstname());
        assertEquals(BIRTHDAY, person.birthday());
    }

    @Test
    public void createRecordPersonWithInvalidArgumentBirthday() {
        LocalDate illegalBirthday =  LocalDate.now().plusDays(1);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
            new PersonCompactConstructor(NAME, FIRSTNAME, illegalBirthday));

        assertTrue(exception.getMessage().contains(String.format(EXCEPTION_MESSAGE_FOR_INVALID_PARAMETERS, "birthday=" + illegalBirthday)));
    }

    @Test
    public void createRecordPersonWithInvalidArgumentsNameBirthday() {
        LocalDate illegalBirthday =  LocalDate.now().plusDays(1);
        String illegalName = NAME.toLowerCase();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
            new PersonCompactConstructor(illegalName, FIRSTNAME, illegalBirthday));

        assertTrue(exception.getMessage().contains(String.format(EXCEPTION_MESSAGE_FOR_INVALID_PARAMETERS, "name="+ illegalName + ",birthday=" + illegalBirthday)));
    }

}