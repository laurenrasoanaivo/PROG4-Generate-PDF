package com.example.prog4swa.controller.model;

import com.example.prog4swa.model.Employee;
import com.example.prog4swa.validation.*;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.DecimalMin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddEmployeeModel {
    @ValidSimpleString
    private String firstName;
    @ValidSimpleString
    private String lastName;
    @ValidDate(value = 18, message = "Employee doit avoir plus de 18 ans et moins de 60 ans")
    private LocalDate birthdate;
    private Employee.Gender gender;
    @ValidPhoneNumber
    private String phoneNumber;
    @ValidPhoneNumber(required = false)
    private String additionalPhoneNumbers;
    @ValidSimpleString(min = 5)
    private String address;
    @ValidUnique(value = "personalEmail")
    private String personalEmail;
    @ValidUnique(value = "professionalEmail")
    private String professionalEmail;
    @ValidUnique(value = "cinNumber")
    @ValidSimplePattern(pattern = "\\d{12}", message = "CIN doit etre au format de 12 chiffres")
    private String cinNumber;
    @ValidDate(value = 0)
    private LocalDate cinIssuanceDate;
    @ValidSimpleString
    private String cinIssuancePlace;
    @ValidSimpleString
    private String position;
    private int dependentChildren;
    @ValidDate(value = 0)
    private LocalDate hireDate;
    @ValidDate(value = 0, required = false)
    private LocalDate departureDate;
    @DecimalMin(value = "0", message = "Ce champs ne peut pas etre negative")
    private double salary;
    @DecimalMin(value = "0", message = "Ce champs ne peut pas etre negative")
    private double benefits;
    @DecimalMin(value = "0", message = "Ce champs ne peut pas etre negative")
    private double allowances;
    @DecimalMin(value = "0", message = "Ce champs ne peut pas etre negative")
    private double socialSecurityContributions;
    @DecimalMin(value = "0", message = "Ce champs ne peut pas etre negative")
    private double taxableIncome;
    @DecimalMin(value = "0", message = "Ce champs ne peut pas etre negative")
    private double taxRate;
    @DecimalMin(value = "0", message = "Ce champs ne peut pas etre negative")
    private double netIncome;
    @ValidUnique(value = "cnaps")
    private String cnaps;
    @Nullable
    private MultipartFile photo;
}

