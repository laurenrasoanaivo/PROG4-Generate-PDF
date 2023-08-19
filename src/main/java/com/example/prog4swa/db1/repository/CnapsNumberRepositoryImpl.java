package com.example.prog4swa.db1.repository;

import com.example.prog4swa.db2.model.DB2Employee;
import com.example.prog4swa.db2.repository.DB2EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CnapsNumberRepositoryImpl implements CnapsNumberRepository {

    @Autowired
    private final DB2EmployeeRepository db2Repository;

    public CnapsNumberRepositoryImpl(DB2EmployeeRepository db2Repository) {
        this.db2Repository = db2Repository;
    }

    @Override
    public String getCnapsNumberByEmployeeId(int employeeId) {
        Optional<DB2Employee> db2Employee = db2Repository.findByEndToEndId(employeeId);
        if (db2Employee.isPresent()) {
            return db2Employee.get().getCnaps();
        }
        return null;
    }
}
