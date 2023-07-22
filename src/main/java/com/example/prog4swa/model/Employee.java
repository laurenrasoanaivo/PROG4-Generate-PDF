package com.example.prog4swa.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@ToString
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String serialNumber;
    private String firstName;
    private String lastName;
    private LocalDate birthdate;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @ElementCollection
    @Column(unique = true)
    @CollectionTable(name = "employee_phone_numbers", joinColumns = @JoinColumn(name = "employee_id"))
    private List<String> phoneNumbers;
    private String address;
    @ElementCollection
    @Column(unique = true)
    @CollectionTable(name = "employee_emails", joinColumns = @JoinColumn(name = "employee_id"))
    private List<String> emails;
    @Column(unique = true)
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
    @Column(unique = true)
    private String cnaps;
    @Column(length = 10000000)
    private String photo;

    public enum Gender {
        MALE,
        FEMALE
    }

}
