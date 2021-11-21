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
public record PersonExended(String  name, String firstname, LocalDate birthday, String city) {

    @Override
    public String toString() {
        return String.format("""
                        PersonExended {
                            name : '%s',
                            firstname : '%s',
                            birthday : %s,
                            city : '%s',
                             
                            }
                        }
                        """,
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
