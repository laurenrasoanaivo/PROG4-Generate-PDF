package com.example.prog4swa.validation;

import com.example.prog4swa.model.Employee;
import com.example.prog4swa.repository.EmployeeRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, String> {

    private static final String PHONE_NUMBER_PATTERN = "\\+261 \\d{2} \\d{2} \\d{3} \\d{2}";
    private boolean REQUIRED;
    private final EmployeeRepository repository;

    public PhoneNumberValidator(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void initialize(ValidPhoneNumber constraintAnnotation) {
        REQUIRED = constraintAnnotation.required();
    }

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
        if (!REQUIRED && phoneNumber == null) {
            return true;
        }
        Optional<List<Employee>> employees = repository.findByPhoneNumber(phoneNumber);
        return Pattern.matches(PHONE_NUMBER_PATTERN, phoneNumber) &&
                (employees.isEmpty() || isPhoneNumberUniqueForEmployee(employees.get()));
    }

    private boolean isPhoneNumberUniqueForEmployee(List<Employee> employees) {
        return employees.size() <= 1;
    }
}