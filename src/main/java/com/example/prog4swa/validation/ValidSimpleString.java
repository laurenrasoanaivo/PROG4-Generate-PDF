package com.example.prog4swa.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SimpleStringValidator.class)
public @interface ValidSimpleString {
    boolean required() default true;
    int min() default 1;
    int max() default 30;
    String message() default "Ce champs ne doit pas etre vide";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

