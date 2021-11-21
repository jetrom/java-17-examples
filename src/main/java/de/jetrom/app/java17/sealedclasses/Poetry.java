package de.jetrom.app.java17.sealedclasses;

import java.time.LocalDate;

/**
 * Book class which belongs to a group of sealed classes, which can implement this interface
 */
public final class Poetry extends Book {

    public static final String GENRE_POEMS = "Genre: poems";

    public Poetry(String title, String author, String publisher, LocalDate publishingDate) {
        super(title, author, publisher, publishingDate);
    }

    @Override
    public String getGenre() {
        return GENRE_POEMS;
    }
}
