package de.jetrom.app.java17.record;

import java.time.LocalDate;

/**
 * Java record type
 * @since JDK 14
 * simple record type
 *
 *
 */
public record Person(String  name, String vorname, LocalDate gebDatum) {
}
