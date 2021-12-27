package de.jetrom.app.java17.record;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Validator for Person record classes
 */
final class PersonConstructorValidator {
    public static final String EXCEPTION_MESSAGE_FOR_INVALID_PARAMETER = "The parameter %s with value: %s is not valid!";

    private PersonConstructorValidator() {}

    @SafeVarargs
    static <T> void validate(final T param, final String paramName, Predicate<Object> checkNullObject, Predicate<T>... additionalChecks) {
        if (Boolean.FALSE.equals(checkNullObject.test(param)
                && Arrays.stream(additionalChecks).allMatch(check -> check.test(param)))) {
            throw new IllegalArgumentException(String.format(EXCEPTION_MESSAGE_FOR_INVALID_PARAMETER, paramName, Objects.toString(param, "null")));
        }
    }

    static Predicate<Object> isNotNull = Objects::nonNull;

    static Predicate<String> isNotBlank = e -> !e.isBlank();

    static Predicate<String> startWithUpperCase = e -> Character.isUpperCase(e.codePointAt(0));

    static Predicate<LocalDate> isValidBirthday = e -> e.isBefore(LocalDate.now());
}
