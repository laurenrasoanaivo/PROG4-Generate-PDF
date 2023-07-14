package com.example.prog4swa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@ToString
public class Employee {
    @Id
    private String serialNumber;
    private String firstName;
    private String lastName;
    private LocalDate birthdate;
    @Column(length = 10000000)
    private String photo;

    public Employee(String serialNumber, String firstName, String lastName, LocalDate birthdate) {
        this.serialNumber = serialNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
    }
}
