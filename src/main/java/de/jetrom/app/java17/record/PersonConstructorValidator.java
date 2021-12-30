package de.jetrom.app.java17.record;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Validator for Person record classes with explicit constructors for validation
 */
final class PersonConstructorValidator {
    static final String EXCEPTION_MESSAGE_FOR_INVALID_PARAMETERS = "The following parameters are not valid: %s";

    private PersonConstructorValidator() {}

    @SafeVarargs
    static <T> Optional<InvalidParameterResult> validate(final T param, final String paramName, Predicate<Object> checkNotNullObject, Predicate<T>... additionalChecks) {
        if (Boolean.FALSE.equals(checkNotNullObject.test(param))) {
            return Optional.of(new InvalidParameterResult(paramName, null));
        }
        if (Arrays.stream(additionalChecks).anyMatch(check -> !check.test(param))) {
            return Optional.of(new InvalidParameterResult(paramName, param.toString()));
        }
        return Optional.empty();
    }

    /**
     * checks the results of the validations for InvalidParameterResults
     * @param optionalInvalidResults list of invalid results
     * @throws  IllegalArgumentException if a value of a parameter is not valid
     */
    @SafeVarargs
    static void checkInvalidParameterResults(Optional<InvalidParameterResult>... optionalInvalidResults) {
        if (Arrays.stream(optionalInvalidResults).anyMatch(Optional::isPresent)) {
            Function<InvalidParameterResult, String> createCompactInvalidParameterResult = e -> e.parameter() + "=" + e.value() ;
            String result = Arrays.stream(optionalInvalidResults).filter(Optional::isPresent).map(Optional::get).map(createCompactInvalidParameterResult).collect(Collectors.joining(","));
            throw new IllegalArgumentException(String.format(EXCEPTION_MESSAGE_FOR_INVALID_PARAMETERS, result));
        }
    }

    static Predicate<Object> isNotNull = Objects::nonNull;

    static Predicate<String> isNotBlank = e -> !e.isBlank();

    static Predicate<String> startWithUpperCase = e -> Character.isUpperCase(e.codePointAt(0));

    static Predicate<LocalDate> isValidBirthday = e -> e.isBefore(LocalDate.now());
}
