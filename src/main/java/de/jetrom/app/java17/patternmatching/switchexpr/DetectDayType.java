package de.jetrom.app.java17.patternmatching.switchexpr;

/**
 * Example of the new switch expressions
 * @since JDK 12
 *
 */
public class DetectDayType {

    public enum DayOfWeek {
        Monday,
        Tuesday,
        Wednesday,
        Thursday,
        Friday,
        Saturday,
        Sunday
    }

    public enum TypeOfDay {
        Weekday,
        Weekend,
        Unknown
    }

    public static TypeOfDay getDayType(DayOfWeek day) {

        return switch(day) {
            case Monday, Tuesday, Wednesday, Thursday, Friday -> TypeOfDay.Weekday;
            case Saturday, Sunday -> TypeOfDay.Weekend;
        };


    }

    public static TypeOfDay getDayTypeOldWay(DayOfWeek day) {
        TypeOfDay result = TypeOfDay.Unknown;
        switch(day) {
            case Monday:
            case Tuesday:
            case Wednesday:
            case Thursday:
            case Friday:
                result = TypeOfDay.Weekday;
                break;
            case Saturday:
            case Sunday:
                result = TypeOfDay.Weekend;
                break;

        };
        return result;
    }
}
