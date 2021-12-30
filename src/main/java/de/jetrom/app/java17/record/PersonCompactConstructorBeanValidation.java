package de.jetrom.app.java17.record;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import static de.jetrom.app.java17.record.PersonConstructorValidator.*;

/**
 * Java record type with compact constructor<br/>
 * This record example has an additional compact constructor to validate the member variables of the constructor<br/>
 * This examples uses the jakarta bean validation api for setting und checking the constraints {@link Validator}
 *
 * @since JDK 14
 * simple record type
 */
public record PersonCompactConstructorBeanValidation(
        @NotBlank(message = "name must not be blank") String  name,
        @NotBlank(message = "firstname must not be blank") String firstname,
        @NotNull(message = "birthday must not be null") @Past(message = "birthday must be in the past") LocalDate birthday,
        @Email(message="email must be a well-formed email address") String email) {

    public static final String MUST_NOT_BE_EMPTY = "Must not be empty";

    // Compact constructor with jakarta bean validation of the arguments
    public PersonCompactConstructorBeanValidation {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<PersonCompactConstructorBeanValidation>> nameViolations = validator.validateValue(PersonCompactConstructorBeanValidation.class, "name", name);
        Set<ConstraintViolation<PersonCompactConstructorBeanValidation>> firstnameViolations = validator.validateValue(PersonCompactConstructorBeanValidation.class, "firstname", firstname);
        Set<ConstraintViolation<PersonCompactConstructorBeanValidation>> birthdayViolations = validator.validateValue(PersonCompactConstructorBeanValidation.class, "birthday", birthday);
        Set<ConstraintViolation<PersonCompactConstructorBeanValidation>> emailViolations = validator.validateValue(PersonCompactConstructorBeanValidation.class, "email", email);
        checkConstraintViolations(nameViolations, firstnameViolations, birthdayViolations, emailViolations);
    }

    static final String EXCEPTION_MESSAGE_FOR_CONSTRAINT_VIOLATIONS = "The parameters have following constraint violations: %s";

    /**
     * checks the list of Set<ConstraintViolation>
     * @param beanPropertyViolations a list of sets of property violations
     * @throws  IllegalArgumentException if at least one bean property value is not valid
     */
    @SafeVarargs
    static void checkConstraintViolations( Set<ConstraintViolation<PersonCompactConstructorBeanValidation>>... beanPropertyViolations) {
        if (Arrays.stream(beanPropertyViolations).anyMatch(e -> !e.isEmpty())) {
            Function<Set<ConstraintViolation<PersonCompactConstructorBeanValidation>>, String> createCompactViolationMessage = e -> e.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(":")) ;
            String violationMessage = Arrays.stream(beanPropertyViolations).filter(e -> !e.isEmpty()).map(createCompactViolationMessage).collect(Collectors.joining(","));
            throw new IllegalArgumentException(String.format(EXCEPTION_MESSAGE_FOR_CONSTRAINT_VIOLATIONS, violationMessage));
        }
    }

}
