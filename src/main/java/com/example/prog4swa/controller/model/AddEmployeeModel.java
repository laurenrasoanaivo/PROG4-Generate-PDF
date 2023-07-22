package com.example.prog4swa.controller.model;

import com.example.prog4swa.model.Employee;
import com.example.prog4swa.validation.ValidDate;
import com.example.prog4swa.validation.ValidPhoneNumber;
import com.example.prog4swa.validation.ValidUnique;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddEmployeeModel {
    @NotBlank(message = "Ce champs est obligatoire")
    @Size(min = 2, max = 30, message = "Prenom doit contenir entre 2 et 30 lettres")
    private String firstName;
    @NotBlank(message = "Ce champs est obligatoire")
    @Size(min = 2, max = 30, message = "Nom doit contenir entre 2 et 30 lettres")
    private String lastName;
    @ValidDate(value = 18, message = "Employee must be over 18 years old and under 60 years old")
    private LocalDate birthdate;
    private Employee.Gender gender;
    @ValidPhoneNumber
    private String phoneNumber;
    @ValidPhoneNumber(required = false)
    private String additionalPhoneNumbers;
    @NotBlank(message = "Ce champs est obligatoire")
    private String address;
    @ValidUnique(value = "personalEmail")
    private String personalEmail;
    @ValidUnique(value = "professionalEmail")
    private String professionalEmail;
    @ValidUnique(value = "cinNumber")
    @Pattern(regexp = "\\d{12}", message = "CIN doit etre au format de 12 chiffres")
    private String cinNumber;
    @ValidDate(value = 0)
    private LocalDate cinIssuanceDate;
    @NotBlank(message = "Ce champs est obligatoire")
    private String cinIssuancePlace;
    @NotBlank(message = "Ce champs est obligatoire")
    @Size(min = 2, max = 30, message = "La fonction doit contenir entre 2 et 30 lettres")
    private String position;
    private int dependentChildren;
    @ValidDate(value = 0)
    private LocalDate hireDate;
    @ValidDate(value = 0, required = false)
    private LocalDate departureDate;
    private double salary;
    private double benefits;
    private double allowances;
    private double socialSecurityContributions;
    private double taxableIncome;
    private double taxRate;
    private double netIncome;
    @ValidUnique(value = "cnaps")
    @Pattern(regexp = "\\d{3}-\\d{3}-\\d{5}", message = "Le numéro CNAPS doit etre au format XXX-XXX-XXXXX")
    private String cnaps;
    @Nullable
    private MultipartFile photo;
}

