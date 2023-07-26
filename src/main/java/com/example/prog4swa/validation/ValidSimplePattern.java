package com.example.prog4swa.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SimplePatternValidator.class)
public @interface ValidSimplePattern {
    boolean required() default true;
    String pattern() default "";
    String message() default "Ce champs doit avoir un format bien defini";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

