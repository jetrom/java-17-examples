package de.jetrom.app.java17.sealedclasses;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void createNovel() {
        var novel = new Novel("Cryptonomicon", "Neal Stephenson", "AVON BOOKS", LocalDate.of(1999, 5,1));
        assertEquals(Novel.GENRE_NOVELS, novel.getGenre());
        assertEquals("Neal Stephenson", novel.getAuthor());


    }




}