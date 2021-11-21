package de.jetrom.app.java17.patternmatching.switchexpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckNumberRangeTest {

    @Test
    public void getRangeOfNumbers() {
        assertEquals(CheckNumberRange.FIVE, CheckNumberRange.getRange(5));
        assertEquals(CheckNumberRange.SMALLER_THAN_FIVE, CheckNumberRange.getRange(1));
        assertEquals(CheckNumberRange.BIGGER_THAN_FIVE, CheckNumberRange.getRange(8));
        assertEquals(CheckNumberRange.OUT_OF_RANGE, CheckNumberRange.getRange(10));
    }

}