package com.example.prog4swa.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class SimplePatternValidator implements ConstraintValidator<ValidSimplePattern, String> {

    private String PATTERN;
    private boolean REQUIRED;

    @Override
    public void initialize(ValidSimplePattern constraintAnnotation) {
        REQUIRED = constraintAnnotation.required();
        PATTERN = constraintAnnotation.pattern();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (!REQUIRED && value.isEmpty()) {
            return true;
        }
        return Pattern.matches(PATTERN, value);
    }

}