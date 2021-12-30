package de.jetrom.app.java17.record;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PersonCompactConstructorBeanValidationTest {

    public static final String NAME = "Wonderland";
    public static final String FIRSTNAME = "Alice";
    public static final LocalDate BIRTHDAY = LocalDate.parse("1999-01-10");
    public static final String EMAIL = "alice@wonderland.world";

    @Test
    public void createRecordPersonWithValidArguments() {
        var person = new PersonCompactConstructorBeanValidation(NAME, FIRSTNAME, BIRTHDAY, EMAIL);

        assertEquals(NAME, person.name());
        assertEquals(FIRSTNAME, person.firstname());
        assertEquals(BIRTHDAY, person.birthday());
        assertEquals(EMAIL, person.email());
    }

    @Test
    public void createRecordPersonWithInvalidArgumentBirthday() {
        LocalDate illegalBirthday =  LocalDate.now().plusDays(1);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
            new PersonCompactConstructorBeanValidation(NAME, FIRSTNAME, illegalBirthday, EMAIL));

        assertTrue(exception.getMessage().contains("birthday must be in the past"));
    }

    @Test
    public void createRecordPersonWithInvalidArgumentsNameEmail() {
        String illegalName = "  ";
        String illegalEmail = "alice@wonderland.";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
            new PersonCompactConstructorBeanValidation(illegalName, FIRSTNAME, BIRTHDAY, illegalEmail));

        assertTrue(exception.getMessage().contains("name must not be blank"));
        assertTrue(exception.getMessage().contains("email must be a well-formed email address"));
    }

}