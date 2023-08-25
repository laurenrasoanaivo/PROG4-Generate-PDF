package com.example.prog4swa.db1.repository;

import com.example.prog4swa.db1.model.Employee;

public interface EmployeeCnapsRepository {
    Employee getEmployeeWithCnapsNumberByEmployeeId(int employeeId);
}
