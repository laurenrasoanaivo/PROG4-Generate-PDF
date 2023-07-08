package com.example.prog4swa.controller;

import com.example.prog4swa.model.Employee;
import com.example.prog4swa.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.sql.Date;
import java.util.Base64;
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

    @GetMapping("/employeeSheet/{serialNumber}")
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



    @GetMapping("/addEmployeeForm")
    public String showAddEmployeeForm() { return "addEmployeeForm"; }

    @PostMapping("/addEmployeeForm")
    public ModelAndView addEmployee(@RequestParam String serialNumber, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String birthDate, @RequestParam("photo") MultipartFile photoFile) {
        ModelAndView modelAndView = new ModelAndView("redirect:/employees");
        Employee employee = new Employee(serialNumber, firstName, lastName, Date.valueOf(birthDate));
        List<Employee> employees = service.getEmployees();
        if (!photoFile.isEmpty()) {
            try {
                byte[] photoBytes = photoFile.getBytes();
                String base64Photo = Base64.getEncoder().encodeToString(photoBytes);
                employee.setPhoto(base64Photo);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        service.addEmployee(employee);
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

}
