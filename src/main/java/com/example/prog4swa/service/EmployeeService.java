package com.example.prog4swa.service;

import com.example.prog4swa.model.Employee;
import com.example.prog4swa.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeService {
    private final EmployeeRepository repository;
    public List<Employee> getEmployees() {
        return repository.findAll();
    }

    public Employee getEmployeeBySerialNumber(String serialNumber) {
        Optional<Employee> employee = repository.findById(serialNumber);
        if(employee.isPresent()){
            return employee.get();
        } else {
            throw new RuntimeException("Resource Employee Not Found");
        }
    }

    public Employee addEmployee(Employee newEmployee){
        return repository.save(newEmployee);
    }
}
