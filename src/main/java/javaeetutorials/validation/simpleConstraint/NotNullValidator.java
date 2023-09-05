package javaeetutorials.validation.simpleConstraint;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NotNullValidator implements ConstraintValidator<NotNullCheck, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null;
    }
}