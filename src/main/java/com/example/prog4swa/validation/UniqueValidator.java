package com.example.prog4swa.validation;

import com.example.prog4swa.model.Employee;
import com.example.prog4swa.repository.EmployeeRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Objects;
import java.util.Optional;

public class UniqueValidator implements ConstraintValidator<ValidUnique, String> {

    private final EmployeeRepository repository;
    private boolean REQUIRED;
    private int employeeId;

    public UniqueValidator(EmployeeRepository repository) {
        this.repository = repository;
    }

    private String VALUE;

    @Override
    public void initialize(ValidUnique constraintAnnotation) {
        REQUIRED = constraintAnnotation.required();
        VALUE = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String valueUnique, ConstraintValidatorContext context) {
        if (!REQUIRED && valueUnique.isEmpty()) {
            return true;
        }

        if (Objects.equals(VALUE, "cinNumber")) {
            Optional<Employee> employeeByCinNumber = repository.findByCinNumber(valueUnique);
            if (employeeByCinNumber.isEmpty()) {
                return true;
            } else {
                Employee existingEmployee = employeeByCinNumber.get();
                return existingEmployee.getId() == employeeId;
            }
        }

        if (Objects.equals(VALUE, "cnaps")) {
            Optional<Employee> employeeByCnaps = repository.findByCnaps(valueUnique);
            if (employeeByCnaps.isEmpty()) {
                return true;
            } else {
                Employee existingEmployee = employeeByCnaps.get();
                return existingEmployee.getId() == employeeId;
            }
        }

        return !valueUnique.isEmpty();
    }

}
