package com.example.prog4swa.repository;

import com.example.prog4swa.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Optional<Employee> findBySerialNumber(String serialNumber);
    //@Query("SELECT e.* FROM employee e JOIN employee_phone_numbers epn ON e.id = epn.employee_id WHERE epn.phone_number = :phoneNumber")
    @Query("SELECT e FROM Employee e WHERE :phoneNumber MEMBER OF e.phoneNumbers")
    Optional<List<Employee>> findByPhoneNumber(@Param("phoneNumber") String phoneNumber);

    Optional<Employee> findByCinNumber(String cinNumber);
    Optional<Employee> findByCnaps(String cnaps);
}
