package de.jetrom.app.java17.record;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;

import static de.jetrom.app.java17.record.PersonConstructorValidator.*;

/**
 * Java record type<br/>
 * This record example has an additional canonical constructor to validate member variables via constructor
 * @since JDK 14
 * simple record type
 *
 *
 */
public record PersonCanonicalConstructor(String  name, String firstname, LocalDate birthday) {
    // here is the canonical constructor with the same parameter for validation
    public PersonCanonicalConstructor( String name, String firstname, LocalDate birthday) {
        checkInvalidParameterResults(
            validate(name, "name", isNotNull, isNotBlank, startWithUpperCase),
            validate(firstname, "firstname", isNotNull, isNotBlank, startWithUpperCase),
            validate(birthday, "birthday", isNotNull, isValidBirthday)
        );
        // assignment needed
        this.name = name;
        this.firstname = firstname;
        this.birthday = birthday;
    }

}
