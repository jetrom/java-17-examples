package de.jetrom.app.java17.patternmatching.switchexpr;

/**
 * Example of the new switch expressions
 * @since JDK 12
 *
 */
public class CheckNumberRange {

    public static final String SMALLER_THAN_FIVE = "Smaller than five";
    public static final String FIVE = "five";
    public static final String BIGGER_THAN_FIVE = "bigger than five";
    public static final String OUT_OF_RANGE = "out of range";

    public static String getRange(int number) {

        return switch(number) {
            case 0, 1, 2, 3, 4 -> SMALLER_THAN_FIVE;
            case 5 -> FIVE;
            case 6, 7, 8, 9 -> BIGGER_THAN_FIVE;
            default -> {
                // code block example with several statements instead of just one
                System.out.println("Number " + number + " out of range!");
                // return value in case block, yield no general key word, only in the context of th switch expression
                yield OUT_OF_RANGE;
            }
        };


    }


}
