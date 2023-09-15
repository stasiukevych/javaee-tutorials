package javaeetutorials.validation.implBasedOnContext;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = {PassportValidator.class})
@Retention(RetentionPolicy.RUNTIME)
@Target({FIELD, TYPE, ANNOTATION_TYPE, CONSTRUCTOR})
public @interface Passport {

  String message() default "{javax.validation.constraints.Passport.message}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  @Target(FIELD)
  @Retention(RetentionPolicy.RUNTIME)
  @interface List {

    Passport[] value();
  }
}