package com.example.prog4swa.controller;

import com.example.prog4swa.model.Employee;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {
    @GetMapping("/employees")
    public ModelAndView getEmployees(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("employees");
        List<Employee> employees = (List<Employee>) session.getAttribute("employees");
        if (employees == null) {
            employees = new ArrayList<>();
            session.setAttribute("employees", employees);
        }
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

    @GetMapping("/addEmployeeForm")
    public String showAddEmployeeForm() {
        return "addEmployeeForm";
    }

    @PostMapping("/addEmployeeForm")
    public ModelAndView addEmployee(HttpSession session, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String birthDate) {
        ModelAndView modelAndView = new ModelAndView("redirect:/employees");
        Employee employee = new Employee(firstName, lastName, Date.valueOf(birthDate));
        List<Employee> employees = (List<Employee>) session.getAttribute("employees");
        employees.add(employee);
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }



}
