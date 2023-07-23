package com.example.prog4swa.controller.mapper;

import com.example.prog4swa.controller.model.AddEmployeeModel;
import com.example.prog4swa.controller.model.EditEmployeeModel;
import com.example.prog4swa.model.Employee;
import com.example.prog4swa.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class EmployeeMapper {
    public final EmployeeService service;

    public Employee toEntity(AddEmployeeModel addEmployee) {
        return Employee.builder()
                .serialNumber(service.generateSerialNumber(addEmployee.getHireDate()))
                .firstName(addEmployee.getFirstName().trim())
                .lastName(addEmployee.getLastName().trim())
                .birthdate(addEmployee.getBirthdate())
                .gender(addEmployee.getGender())
                .phoneNumbers(addEmployee.getAdditionalPhoneNumbers() == null ?
                        List.of(addEmployee.getPhoneNumber()) :
                        List.of(addEmployee.getPhoneNumber(),
                                addEmployee.getAdditionalPhoneNumbers()
                        ))
                .address(addEmployee.getAddress().trim())
                .emails(List.of(addEmployee.getPersonalEmail().trim(), addEmployee.getProfessionalEmail().trim()))
                .cinNumber(addEmployee.getCinNumber())
                .cinIssuanceDate(addEmployee.getCinIssuanceDate())
                .cinIssuancePlace(addEmployee.getCinIssuancePlace().trim())
                .position(addEmployee.getPosition().trim())
                .dependentChildren(addEmployee.getDependentChildren())
                .hireDate(addEmployee.getHireDate())
                .departureDate(addEmployee.getDepartureDate())
                .salary(addEmployee.getSalary())
                .benefits(addEmployee.getBenefits())
                .allowances(addEmployee.getAllowances())
                .socialSecurityContributions(addEmployee.getSocialSecurityContributions())
                .taxableIncome(addEmployee.getTaxableIncome())
                .taxRate(addEmployee.getTaxRate())
                .cnaps(addEmployee.getCnaps())
                .photo(addEmployee.getPhoto() != null ? service.convertToBase64Photo(addEmployee.getPhoto()) : null)
                .build();
    }

    public Employee toEntity(EditEmployeeModel editEmployee) {
        return Employee.builder()
                .id(editEmployee.getId())
                .serialNumber(editEmployee.getSerialNumber())
                .firstName(editEmployee.getFirstName().trim())
                .lastName(editEmployee.getLastName().trim())
                .birthdate(editEmployee.getBirthdate())
                .gender(editEmployee.getGender())
                .phoneNumbers(editEmployee.getAdditionalPhoneNumbers() == null ?
                        List.of(editEmployee.getPhoneNumber()) :
                        List.of(editEmployee.getPhoneNumber(),
                                editEmployee.getAdditionalPhoneNumbers()
                        ))
                .address(editEmployee.getAddress().trim())
                .emails(List.of(editEmployee.getPersonalEmail().trim(), editEmployee.getProfessionalEmail().trim()))
                .cinNumber(editEmployee.getCinNumber())
                .cinIssuanceDate(editEmployee.getCinIssuanceDate())
                .cinIssuancePlace(editEmployee.getCinIssuancePlace().trim())
                .position(editEmployee.getPosition().trim())
                .dependentChildren(editEmployee.getDependentChildren())
                .hireDate(editEmployee.getHireDate())
                .departureDate(editEmployee.getDepartureDate())
                .salary(editEmployee.getSalary())
                .benefits(editEmployee.getBenefits())
                .allowances(editEmployee.getAllowances())
                .socialSecurityContributions(editEmployee.getSocialSecurityContributions())
                .taxableIncome(editEmployee.getTaxableIncome())
                .taxRate(editEmployee.getTaxRate())
                .netIncome(editEmployee.getNetIncome())
                .cnaps(editEmployee.getCnaps())
                .photo(editEmployee.getPhoto())
                .build();
    }

    public EditEmployeeModel toEditEmployeeModel(Employee employee) {
        return EditEmployeeModel.builder()
                .id(employee.getId())
                .serialNumber(employee.getSerialNumber())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .birthdate(employee.getBirthdate())
                .gender(employee.getGender())
                .phoneNumber(employee.getPhoneNumbers().get(0))
                .additionalPhoneNumbers(employee.getPhoneNumbers().size()>1 ? employee.getPhoneNumbers().get(1) : null)
                .address(employee.getAddress())
                .personalEmail(employee.getEmails().get(0))
                .professionalEmail(employee.getEmails().get(1))
                .cinNumber(employee.getCinNumber())
                .cinIssuanceDate(employee.getCinIssuanceDate())
                .cinIssuancePlace(employee.getCinIssuancePlace())
                .position(employee.getPosition().trim())
                .dependentChildren(employee.getDependentChildren())
                .hireDate(employee.getHireDate())
                .departureDate(employee.getDepartureDate())
                .salary(employee.getSalary())
                .benefits(employee.getBenefits())
                .allowances(employee.getAllowances())
                .socialSecurityContributions(employee.getSocialSecurityContributions())
                .taxableIncome(employee.getTaxableIncome())
                .taxRate(employee.getTaxRate())
                .netIncome(employee.getNetIncome())
                .cnaps(employee.getCnaps())
                .photo(employee.getPhoto())
                .build();
    }

}
