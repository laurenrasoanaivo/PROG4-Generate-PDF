package com.example.prog4swa.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String userName;
    private String password;

}