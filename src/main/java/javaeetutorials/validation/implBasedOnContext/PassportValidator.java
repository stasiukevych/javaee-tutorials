package javaeetutorials.validation.implBasedOnContext;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PassportValidator implements ConstraintValidator<Passport, PassportItem> {

    @Override
    public boolean isValid(PassportItem value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        if (value.id == null) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Passport item id is invalid.")
                    .addConstraintViolation();
            return false;
        }

        if (value.type == null || value.type.length() <= 1) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Passport item type is invalid.")
                    .addConstraintViolation();
            return false;
        }

        if (value.info == null) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Passport item info is invalid.")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}