package com.example.prog4swa.service;

import com.example.prog4swa.model.Company;
import com.example.prog4swa.repository.CompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CompanyService {
    private final CompanyRepository repository;

    public Company getCompany() {
        return repository.findAll().get(0);
    }

}
