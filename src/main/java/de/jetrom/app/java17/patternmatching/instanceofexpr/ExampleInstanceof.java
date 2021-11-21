package de.jetrom.app.java17.patternmatching.instanceofexpr;

import java.util.Collection;

/**
 * Example of new Pasttern matching for instanceof
 * @since JDK 16
 */
public class ExampleInstanceof {

    public static boolean isNullOrEmpty(Object o) {
        return o == null
                || o instanceof String str && str.isEmpty()
                || o instanceof  Collection coll && coll.isEmpty();
    }

    /**
     * Example of the new preview feature Pattern Matching for switch cases
     * * @since Java 17 preview
     * @param o Object
     * @return boolean true if is null or empty
     */
    public static boolean isNullOrEmptyWithSwitchExpression(Object o) {
        return switch (o) {
            case null -> true;
            case String s -> s.isEmpty();
            case Collection c -> c.isEmpty();

            default -> false;
        };
    }


}
