package com.example.prog4swa.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateValidator.class)
public @interface ValidDate {
    int value() default 18;
    int valueMax() default 60;
    boolean required() default true;
    String message() default "Date Invalide";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

