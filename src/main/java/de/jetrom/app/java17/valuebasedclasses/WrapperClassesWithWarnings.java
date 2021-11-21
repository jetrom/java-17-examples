package de.jetrom.app.java17.valuebasedclasses;

/**
 * Deprecated Warnings for Value-Based Classes
 * @since JDK 16
 */
public class WrapperClassesWithWarnings {

    public static void run() {

        // Constructor deprecated warning
        Double number = new Double(20.1);
        System.out.println("Number = " + number);

        // warning Instance synchronisation
        synchronized (number) {
            System.out.println("Synchronized Block on Instance of Number = " + number);
        }

    }
}
