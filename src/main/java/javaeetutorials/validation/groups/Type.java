package javaeetutorials.validation.groups;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = {})
@NotNull(message = "should not be null: ${validatedValue}")
@Size(min = 5)
@Retention(RetentionPolicy.RUNTIME)
@Target({FIELD, TYPE, ANNOTATION_TYPE, CONSTRUCTOR})
public @interface Type {

  String message() default "{javax.validation.constraints.Passport.message}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}