package com.example.prog4swa.controller;

import com.example.prog4swa.controller.mapper.CompanyMapper;
import com.example.prog4swa.controller.model.EditCompanyModel;
import com.example.prog4swa.service.CompanyService;
import com.example.prog4swa.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
@AllArgsConstructor
public class CompanyController implements WebMvcConfigurer {
    private final CompanyService service;
    private final EmployeeService employeeService;
    private final CompanyMapper mapper;

    @ModelAttribute("company")
    public EditCompanyModel sharedCompany() {
        return mapper.toEditCompanyModel(service.getCompany());
    }

    @GetMapping("/company/edit")
    private String showEditCompany(){
        return "edit-company";
    }

    @PutMapping(value = "/company/edit", consumes = "multipart/form-data")
    private String editCompany(EditCompanyModel company,
                               MultipartFile logoFile){
        if(logoFile != null && !logoFile.isEmpty()){
            company.setLogo(employeeService.convertToBase64Photo(logoFile));
        }
        service.updateCompany(mapper.toEntity(company));
        return "redirect:/employees";
    }
}
