package com.example.prog4swa.service;

import com.example.prog4swa.model.Employee;
import com.example.prog4swa.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
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

    public void addOrUpdateEmployee(Employee newEmployee){
        repository.save(newEmployee);
    }

    public void convertToBase64Photo(Employee employee, MultipartFile photoFile) {
        try {
            byte[] photoBytes = photoFile.getBytes();
            String base64Photo = Base64.getEncoder().encodeToString(photoBytes);
            employee.setPhoto(base64Photo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
