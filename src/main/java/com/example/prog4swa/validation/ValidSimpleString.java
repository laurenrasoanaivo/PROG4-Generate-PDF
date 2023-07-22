package com.example.prog4swa.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SimpleStringValidator.class)
public @interface ValidSimpleString {
    boolean required() default true;
    int min() default 2;
    int max() default 30;
    String message() default "Ce champs doit contenir entre 2 et 30 lettres";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

