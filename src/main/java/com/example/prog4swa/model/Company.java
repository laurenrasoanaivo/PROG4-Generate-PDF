package com.example.prog4swa.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String slogan;
    private String address;
    private String email;
    private String phoneNumber;
    private String nif;
    private String stat;
    private String rcs;
    @Column(length = 10000000)
    private String logo;

}
