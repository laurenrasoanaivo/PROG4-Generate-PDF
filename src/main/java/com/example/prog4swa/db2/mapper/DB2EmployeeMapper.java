package com.example.prog4swa.db2.mapper;

import com.example.prog4swa.db1.model.Employee;
import com.example.prog4swa.db2.model.DB2Employee;
import com.example.prog4swa.db2.repository.DB2EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DB2EmployeeMapper {
    @Autowired
    private final DB2EmployeeRepository repository;

    public DB2Employee toEntity(Employee employee) {
        return DB2Employee.builder()
                .serialNumber(employee.getSerialNumber())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .birthdate(employee.getBirthdate())
                .gender(employee.getGender())
                .phoneNumbers(employee.getPhoneNumbers())
                .address(employee.getAddress())
                .emails(employee.getEmails())
                .cinNumber(employee.getCinNumber())
                .cinIssuanceDate(employee.getCinIssuanceDate())
                .cinIssuancePlace(employee.getCinIssuancePlace())
                .position(employee.getPosition())
                .dependentChildren(employee.getDependentChildren())
                .hireDate(employee.getHireDate())
                .departureDate(employee.getDepartureDate())
                .salary(employee.getSalary())
                .benefits(employee.getBenefits())
                .allowances(employee.getAllowances())
                .socialSecurityContributions(employee.getSocialSecurityContributions())
                .taxableIncome(employee.getTaxableIncome())
                .taxRate(employee.getTaxRate())
                .cnaps(employee.getCnaps())
                .photo(employee.getPhoto())
                .endToEndId(employee.getId())
                .build();
    }

    public DB2Employee toEntityEdit(Employee employee) {
        DB2Employee originalEmployee = repository.findByEndToEndId(employee.getId()).get();
        return DB2Employee.builder()
                .id(originalEmployee.getId())
                .serialNumber(employee.getSerialNumber())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .birthdate(employee.getBirthdate())
                .gender(employee.getGender())
                .phoneNumbers(employee.getPhoneNumbers())
                .address(employee.getAddress())
                .emails(employee.getEmails())
                .cinNumber(employee.getCinNumber())
                .cinIssuanceDate(employee.getCinIssuanceDate())
                .cinIssuancePlace(employee.getCinIssuancePlace())
                .position(employee.getPosition())
                .dependentChildren(employee.getDependentChildren())
                .hireDate(employee.getHireDate())
                .departureDate(employee.getDepartureDate())
                .salary(employee.getSalary())
                .benefits(employee.getBenefits())
                .allowances(employee.getAllowances())
                .socialSecurityContributions(employee.getSocialSecurityContributions())
                .taxableIncome(employee.getTaxableIncome())
                .taxRate(employee.getTaxRate())
                .cnaps(employee.getCnaps())
                .photo(employee.getPhoto())
                .endToEndId(employee.getId())
                .build();
    }

}
