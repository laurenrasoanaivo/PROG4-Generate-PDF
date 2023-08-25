package com.example.prog4swa.db1.repository;

import com.example.prog4swa.db1.model.Employee;
import com.example.prog4swa.db2.model.DB2Employee;
import com.example.prog4swa.db2.repository.DB2EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class EmployeeCnapsRepositoryImpl implements EmployeeCnapsRepository {
    @Autowired
    private final EmployeeRepository repository;
    @Autowired
    private final DB2EmployeeRepository db2Repository;

    public EmployeeCnapsRepositoryImpl(DB2EmployeeRepository db2Repository, EmployeeRepository repository) {
        this.db2Repository = db2Repository;
        this.repository = repository;
    }

    @Override
    public Employee getEmployeeWithCnapsNumberByEmployeeId(int employeeId) {
        Optional<Employee> employee = repository.findById(employeeId);
        Optional<DB2Employee> db2Employee = db2Repository.findByEndToEndId(employeeId);
        if (employee.isPresent() && db2Employee.isPresent()) {
            employee.get().setCnaps(db2Employee.get().getCnaps());
            return employee.get();
        } else if(employee.isPresent()) {
            return employee.get();
        } else {
            throw new RuntimeException("Resource Employee Not Found");
        }
    }
}
