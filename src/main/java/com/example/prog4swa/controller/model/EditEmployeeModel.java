package com.example.prog4swa.controller.model;

import com.example.prog4swa.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EditEmployeeModel {
    private int id;
    private String serialNumber;
    private String firstName;
    private String lastName;
    private LocalDate birthdate;
    private Employee.Gender gender;
    private String phoneNumbers;
    private String address;
    private String personalEmail;
    private String professionalEmail;
    private String cinNumber;
    LocalDate cinIssuanceDate;
    private String cinIssuancePlace;
    private String position;
    private int dependentChildren;
    private LocalDate hireDate;
    private LocalDate departureDate;
    private double salary;
    private double benefits;
    private double allowances;
    private double socialSecurityContributions;
    private double taxableIncome;
    private double taxRate;
    private double netIncome;
    private String cnaps;
    private String photo;
}

