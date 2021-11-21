package de.jetrom.app.java17.sealedclasses;

import java.time.LocalDate;

/**
 * Exampples of sealed classes and Interfaces<br/>
 * Only the 4 Classes are allowed to implement this interface
 *
 * @since JDK 16
 * @see <a href="https://openjdk.java.net/jeps/397">jeps/397</a>
 */
public sealed abstract class Book permits Novel, ShortStories, Poetry, NonFictionBook {

    protected String title;
    protected String author;
    protected String publisher;
    protected String genre;
    protected LocalDate publishingDate;

    protected Book(String title, String author, String publisher, LocalDate publishingDate) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publishingDate = publishingDate;
    }

    public  String getTitle() {
        return title;
    }

    public String getAuthor() {
        return  author;
    }

    public String getPublisher(){
     return publisher;
    }

    public LocalDate getPublishingDate() {
     return publishingDate;
    }

    public abstract String getGenre();

}
