package de.jetrom.app.java17.sealedclasses;

import java.time.LocalDate;

/**
 * Book class which belongs to a group of sealed classes, which can implement this interface
 */
public final class ShortStories extends Book {

    public static final String GENRE_SHORT_STORIES = "Genre: short stories";

    public ShortStories(String title, String author, String publisher, LocalDate publishingDate) {
        super(title, author, publisher, publishingDate);
    }

    @Override
    public String getGenre() {
        return GENRE_SHORT_STORIES;
    }
}
