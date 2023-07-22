package com.example.prog4swa.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PhoneNumberValidator.class)
public @interface ValidPhoneNumber {
    boolean required() default true;
    String message() default "Telephone invalide (Format XX XX XXX XX et unique)";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

