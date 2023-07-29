package com.example.prog4swa.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class Company {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String slogan;
    private String address;
    private String email;
    //@Enumerated(EnumType.STRING)
    //private Employee.CountryCode countryCode;
    @ElementCollection
    @Column(unique = true)
    @CollectionTable(name = "all_phone_numbers", joinColumns = @JoinColumn(name = "company_id"))
    private List<String> phoneNumbers;
    private String nif;
    private String stat;
    private String rcs;
    @Column(length = 10000000)
    private String logo;

}
