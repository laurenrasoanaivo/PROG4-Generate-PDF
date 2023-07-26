package com.example.prog4swa.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueValidator.class)
public @interface ValidUnique {
    String value() default "";
    boolean required() default true;
    String message() default "Ce champs est obligatoire et unique";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
