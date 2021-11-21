package de.jetrom.app.java17.patternmatching.instanceofexpr;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class ExampleInstanceofTest {

    @Test
    @DisplayName("Test isNullOrEmpty via logical operators true cases")
    public void isNullOrEmptyTrue() {
        assertTrue(ExampleInstanceof.isNullOrEmpty(null));
        assertTrue(ExampleInstanceof.isNullOrEmpty(""));
        assertTrue(ExampleInstanceof.isNullOrEmpty(Collections.emptyList()));

    }
    @Test
    @DisplayName("Test isNullOrEmpty via logical operators false cases")
    public void isNullOrEmptyFalse() {
        assertFalse(ExampleInstanceof.isNullOrEmpty(new Object()));
        assertFalse(ExampleInstanceof.isNullOrEmpty("123"));
        assertFalse(ExampleInstanceof.isNullOrEmpty(Arrays.asList(1, 2)));

    }

}