package com.example.prog4swa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Employee {
    private String firstName;
    private String lastName;
    private Date birthDate;
}
