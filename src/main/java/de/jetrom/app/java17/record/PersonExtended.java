package de.jetrom.app.java17.record;

import java.time.LocalDate;

/**
 * Java record type
 * @since JDK 14
 * extended record type
 *  overriding a method
 *  adding a new method
 *
 *
 */
public record PersonExtended(String  name, String firstname, LocalDate birthday, String city) {

    public static final String PERSON_EXTENDED_STRING = """
            PersonExtended {
                name : '%s',
                firstname : '%s',
                birthday : %s,
                city : '%s',
                 
                }
            }
            """;

    @Override
    public String toString() {
        return String.format(PERSON_EXTENDED_STRING,
                name,
                firstname,
                birthday,
                city
        );
    }

        public String cityUpperCase() {
            return city.toUpperCase();
        }

}
