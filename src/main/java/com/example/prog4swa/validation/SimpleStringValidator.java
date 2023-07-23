package com.example.prog4swa.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SimpleStringValidator implements ConstraintValidator<ValidSimpleString, String> {

    private boolean REQUIRED;
    private int MIN;
    private int MAX;

    @Override
    public void initialize(ValidSimpleString constraintAnnotation) {
        REQUIRED = constraintAnnotation.required();
        MIN = constraintAnnotation.min();
        MAX = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (!REQUIRED && value.isBlank()) {
            return true;
        }
        int length = value.trim().length();
        return length >= MIN && length <= MAX;
    }

}