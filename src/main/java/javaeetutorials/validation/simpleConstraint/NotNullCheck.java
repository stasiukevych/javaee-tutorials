package javaeetutorials.validation.simpleConstraint;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({TYPE, FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {NotNullValidator.class})
public @interface NotNullCheck {

  String message() default "{javax.validation.constraints.NotNull.message}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}