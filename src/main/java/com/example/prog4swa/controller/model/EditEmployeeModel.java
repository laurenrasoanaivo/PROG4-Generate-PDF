package com.example.prog4swa.controller.model;

import com.example.prog4swa.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EditEmployeeModel {
    //27
    private int id;
    private String serialNumber;
    private String firstName;
    private String lastName;
    private LocalDate birthdate;
    private Employee.Gender gender;
    private String phoneNumber;
    private String additionalPhoneNumbers;
    private String address;
    private String personalEmail;
    private String professionalEmail;
    private String cinNumber;
    private LocalDate cinIssuanceDate;
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

