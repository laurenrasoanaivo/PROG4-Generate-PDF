package com.example.prog4swa.controller.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Data
public class EditEmployeeModel {
    private String firstName;
    private String lastName;
    private LocalDate birthdate;
    private MultipartFile photoFile;
}

