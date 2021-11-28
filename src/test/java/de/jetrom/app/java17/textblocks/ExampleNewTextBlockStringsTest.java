package de.jetrom.app.java17.textblocks;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ExampleNewTextBlockStringsTest {

    public static final String OLD_STRING_LITERAL = "Old String Literal:";
    public static final String NEW_TEXT_BLOCK = "New Text Block:";

    @Test
    @Order(1)
    public void compareAndOutputTextLinesTextBlock() {
        assertEquals(ExampleNewTextBlockStrings.textLinesStringLiteral, ExampleNewTextBlockStrings.textLinesNewTextBlock);
        System.out.println(OLD_STRING_LITERAL);
        System.out.println(ExampleNewTextBlockStrings.textLinesStringLiteral);
        System.out.println(NEW_TEXT_BLOCK);
        System.out.println(ExampleNewTextBlockStrings.textLinesNewTextBlock);

    }

    @Test
    @Order(2)
    public void compareAndOutputHtmlStringTextBlock() {
        assertEquals(ExampleNewTextBlockStrings.htmlStringLiteral, ExampleNewTextBlockStrings.htmlNewTextBlock);
        System.out.println(OLD_STRING_LITERAL);
        System.out.println(ExampleNewTextBlockStrings.htmlStringLiteral);
        System.out.println(NEW_TEXT_BLOCK);
        System.out.println(ExampleNewTextBlockStrings.htmlNewTextBlock);

    }

    @Test
    @Order(3)
    public void compareAndOutputJsonStringTextBlock() {
        assertEquals(ExampleNewTextBlockStrings.jsonStringLiteral, ExampleNewTextBlockStrings.jsonTextBlock);
        System.out.println(OLD_STRING_LITERAL);
        System.out.println(ExampleNewTextBlockStrings.jsonStringLiteral);
        System.out.println(NEW_TEXT_BLOCK);
        System.out.println(ExampleNewTextBlockStrings.jsonTextBlock);

    }

    @Test
    @Order(4)
    public void getTextLinesNewTextBlockWithPlaceHolders() {
        String name = "world";
        LocalDate today = LocalDate.now();
        String textLinesNewTextBlockWithPlaceHolders = ExampleNewTextBlockStrings.getTextLinesNewTextBlockWithPlaceHolders(name, today);
        System.out.println(textLinesNewTextBlockWithPlaceHolders);
        assertTrue(textLinesNewTextBlockWithPlaceHolders.contains(name));
    }

}