package de.jetrom.app.java17.record;

import java.time.LocalDate;

import static de.jetrom.app.java17.record.PersonConstructorValidator.*;

/**
 * Java record type with compact constructor<br/>
 * This record example has an additional compact constructor to validate the member variables of the constructor<br/>
 * For comparison see the example with the canonical constructor {@link PersonCanonicalConstructor}
 *
 * @since JDK 14
 * simple record type
 */
public record PersonCompactConstructor(String  name, String firstname, LocalDate birthday) {

    // Compact constructor for validation of the arguments requires less code
    public PersonCompactConstructor {
        validate(name, "name", isNotNull, isNotBlank, startWithUpperCase);
        validate(firstname, "firstname", isNotNull, isNotBlank, startWithUpperCase);
        validate(birthday, "birthday", isNotNull, isValidBirthday);
    }


}
