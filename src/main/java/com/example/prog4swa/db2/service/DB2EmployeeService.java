package com.example.prog4swa.db2.service;

import com.example.prog4swa.db2.model.DB2Employee;
import com.example.prog4swa.db2.repository.DB2EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class DB2EmployeeService {
    @Autowired
    private final DB2EmployeeRepository repository;

    public DB2EmployeeService(DB2EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<DB2Employee> getEmployees() {
        return repository.findAll();
    }

    public DB2Employee getDB2EmployeeById(int id) {
        Optional<DB2Employee> employee = repository.findById(id);
        if(employee.isPresent()){
            return employee.get();
        } else {
            throw new RuntimeException("Resource Employee Not Found");
        }
    }

    public void addOrUpdateDB2Employee(DB2Employee newEmployee){
        repository.save(newEmployee);
    }

}
