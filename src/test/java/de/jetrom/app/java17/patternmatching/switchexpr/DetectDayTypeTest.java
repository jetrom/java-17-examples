package de.jetrom.app.java17.patternmatching.switchexpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DetectDayTypeTest {

    @Test
    public void getDayTypeOldWay() {
        assertEquals(DetectDayType.TypeOfDay.Weekday, DetectDayType.getDayTypeOldWay(DetectDayType.DayOfWeek.Monday));
        assertEquals(DetectDayType.TypeOfDay.Weekday, DetectDayType.getDayTypeOldWay(DetectDayType.DayOfWeek.Friday));
        assertEquals(DetectDayType.TypeOfDay.Weekend, DetectDayType.getDayTypeOldWay(DetectDayType.DayOfWeek.Sunday));
        assertNotEquals(DetectDayType.TypeOfDay.Weekday, DetectDayType.getDayTypeOldWay(DetectDayType.DayOfWeek.Saturday));
    }

    @Test
    public void getDayType() {
        assertEquals(DetectDayType.TypeOfDay.Weekday, DetectDayType.getDayType(DetectDayType.DayOfWeek.Monday));
        assertEquals(DetectDayType.TypeOfDay.Weekday, DetectDayType.getDayType(DetectDayType.DayOfWeek.Friday));
        assertEquals(DetectDayType.TypeOfDay.Weekend, DetectDayType.getDayType(DetectDayType.DayOfWeek.Sunday));
        assertNotEquals(DetectDayType.TypeOfDay.Weekday, DetectDayType.getDayType(DetectDayType.DayOfWeek.Saturday));
    }
}