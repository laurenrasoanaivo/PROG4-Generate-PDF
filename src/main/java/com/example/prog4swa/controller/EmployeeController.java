package com.example.prog4swa.controller;

import com.example.prog4swa.controller.model.EditEmployeeModel;
import com.example.prog4swa.model.Employee;
import com.example.prog4swa.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;

@Controller
@AllArgsConstructor
public class EmployeeController {
    private final EmployeeService service;
    @GetMapping("/employees")
    public ModelAndView getEmployees() {
        ModelAndView modelAndView = new ModelAndView("employees");
        List<Employee> employees = service.getEmployees();
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

    @GetMapping("/employees/{serialNumber}")
    public ModelAndView getEmployeeSheet(@PathVariable String serialNumber) {
        ModelAndView modelAndView = new ModelAndView("employeeSheet");
        try {
            Employee employee = service.getEmployeeBySerialNumber(serialNumber);
            modelAndView.addObject("employeeSheet", employee);
        } catch (RuntimeException e) {
            modelAndView.addObject("errorMessage", "Employee with serial number " + serialNumber + " not found");
        }
        return modelAndView;
    }

    @GetMapping("/employees/add")
    public ModelAndView showAddEmployeeForm() {
        ModelAndView modelAndView = new ModelAndView("employeeForm");
        modelAndView.addObject("actionUrl", "/employees/add");
        return modelAndView;
    }

    @GetMapping("/employees/edit/{serialNumber}")
    public ModelAndView showEditEmployeeForm(@PathVariable String serialNumber) {
        ModelAndView modelAndView = new ModelAndView("employeeForm");
        Employee employee = service.getEmployeeBySerialNumber(serialNumber);
        modelAndView.addObject("employeeForm", employee);
        modelAndView.addObject("actionUrl", "/employees/edit/" + serialNumber);
        return modelAndView;
    }

    @PostMapping("/employees/add")
    public ModelAndView addEmployee(@RequestParam String serialNumber, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String birthdate, @RequestParam("photo") MultipartFile photoFile) {
        ModelAndView modelAndView = new ModelAndView("redirect:/employees");
        Employee employee = new Employee(serialNumber, firstName, lastName, LocalDate.parse(birthdate));
        List<Employee> employees = service.getEmployees();
        if(!photoFile.isEmpty()){
            service.convertToBase64Photo(employee, photoFile);
        }
        service.addOrUpdateEmployee(employee);
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

    @PatchMapping(value = "/employees/edit/{serialNumber}", consumes = "multipart/form-data")
    public ModelAndView editEmployee(@PathVariable String serialNumber, @ModelAttribute EditEmployeeModel editEmployee, @RequestParam(value = "photo", required = false) MultipartFile photoFile) {
        ModelAndView modelAndView = new ModelAndView("redirect:/employees");
        Employee employee = service.getEmployeeBySerialNumber(serialNumber);
        if (editEmployee.getFirstName() != null && !editEmployee.getFirstName().isBlank()) {
            employee.setFirstName(editEmployee.getFirstName());
        }
        if (editEmployee.getLastName() != null && !editEmployee.getLastName().isBlank()) {
            employee.setLastName(editEmployee.getLastName());
        }
        if (photoFile != null && !photoFile.isEmpty()) {
            service.convertToBase64Photo(employee, photoFile);
        }
        service.addOrUpdateEmployee(employee);
        List<Employee> employees = service.getEmployees();
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

}
