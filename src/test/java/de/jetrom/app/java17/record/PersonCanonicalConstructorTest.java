package de.jetrom.app.java17.record;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Objects;

import static de.jetrom.app.java17.record.PersonConstructorValidator.EXCEPTION_MESSAGE_FOR_INVALID_PARAMETER;
import static org.junit.jupiter.api.Assertions.*;

class PersonCanonicalConstructorTest {

    public static final String NAME = "Miller";
    public static final String FIRSTNAME = "Peter";
    public static final LocalDate BIRTHDAY = LocalDate.parse("2000-12-01");

    @Test
    public void createRecordPersonWithValidArguments() {
        var person = new PersonCanonicalConstructor(NAME, FIRSTNAME, BIRTHDAY);

        assertEquals(NAME, person.name());
        assertEquals(FIRSTNAME, person.firstname());
        assertEquals(BIRTHDAY, person.birthday());
    }

    @Test
    public void createRecordPersonWithInvalidArguments() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                new PersonCanonicalConstructor(NAME, "", BIRTHDAY));

        Assertions.assertEquals(String.format(EXCEPTION_MESSAGE_FOR_INVALID_PARAMETER, "firstname", ""), exception.getMessage());
    }

}