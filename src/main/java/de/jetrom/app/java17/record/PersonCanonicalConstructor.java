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

        validate(name, "name", isNotNull, isNotBlank, startWithUpperCase);
        this.name = name;

        validate(firstname, "firstname", isNotNull, isNotBlank, startWithUpperCase);
        this.firstname = firstname;

        validate(birthday, "birthday", isNotNull, isValidBirthday);
        this.birthday = birthday;
    }

}
