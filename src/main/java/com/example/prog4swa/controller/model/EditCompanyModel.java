package com.example.prog4swa.controller.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class EditCompanyModel {
    private int id;
    private String name;
    private String description;
    private String slogan;
    private String address;
    private String email;
    private String phoneNumbers;
    private String nif;
    private String stat;
    private String rcs;
    @Column(length = 10000000)
    private String logo;
}
