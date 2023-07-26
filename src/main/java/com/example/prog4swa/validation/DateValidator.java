package com.example.prog4swa.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class DateValidator implements ConstraintValidator<ValidDate, LocalDate> {
    private int MINIMUM_AGE ;
    private int MAXIMUM_AGE ;
    private boolean REQUIRED;

    @Override
    public void initialize(ValidDate constraintAnnotation) {
        MAXIMUM_AGE = constraintAnnotation.valueMax();
        MINIMUM_AGE = constraintAnnotation.value();
        REQUIRED = constraintAnnotation.required();
    }

    @Override
    public boolean isValid(LocalDate anyDate, ConstraintValidatorContext context) {

        if(!REQUIRED && anyDate == null){
            return true;
        }

        LocalDate today = LocalDate.now();
        LocalDate minimumAgeDate = today.minusYears(MINIMUM_AGE);
        LocalDate maximumAgeDate = today.minusYears(MAXIMUM_AGE);

        return anyDate.isBefore(today) && anyDate.isBefore(minimumAgeDate) && anyDate.isAfter(maximumAgeDate);
    }
}

