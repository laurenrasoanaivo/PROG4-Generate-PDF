package com.example.prog4swa.controller;

import com.example.prog4swa.controller.mapper.EmployeeMapper;
import com.example.prog4swa.controller.model.AddEmployeeModel;
import com.example.prog4swa.controller.model.EditEmployeeModel;
import com.example.prog4swa.model.Company;
import com.example.prog4swa.model.Employee;
import com.example.prog4swa.service.CompanyService;
import com.example.prog4swa.service.EmployeeService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Controller
@AllArgsConstructor
public class EmployeeController implements WebMvcConfigurer {
    private final EmployeeService service;
    private final CompanyService companyService;
    private final EmployeeMapper mapper;

    @ModelAttribute("company")
    public Company sharedCompany() {
        return companyService.getCompany();
    }

    @GetMapping("/employees")
    public String showEmployeeList(@RequestParam(name = "firstName", required = false) String firstName,
                                   @RequestParam(name = "lastName", required = false) String lastName,
                                   @RequestParam(name = "gender", required = false) String gender,
                                   @RequestParam(name = "position", required = false) String position,
                                   @RequestParam(name = "hireDate", required = false) String hireDate,
                                   @RequestParam(name = "departureDate", required = false) String departureDate,
                                   @RequestParam(name = "sort", defaultValue = "") String sort,
                                   Model model) {
        List<Employee> employees = service.customSearch(firstName, lastName, gender, position, hireDate, departureDate, sort);
        model.addAttribute("employees", employees);
        return "employees";
    }

    @GetMapping("/employees/{id}")
    public ModelAndView getEmployeeSheet(@PathVariable int id) {
        Employee employee = service.getEmployeeById(id);
        return new ModelAndView("employee-sheet")
                .addObject("employeeSheet", employee);
    }

    @GetMapping("/employees/add")
    public String showAddEmployeeForm(AddEmployeeModel addEmployeeModel) {
        return "add-employee";
    }

    @PostMapping(value = "/employees/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String addEmployee(AddEmployeeModel addEmployeeModel) {
        service.addOrUpdateEmployee(mapper.toEntity(addEmployeeModel));
        return "redirect:/employees";
    }

    @GetMapping("/employees/edit/{id}")
    public ModelAndView showEditEmployeeForm(@PathVariable int id) {
        Employee existingEmployee = service.getEmployeeById(id);
        return new ModelAndView("edit-employee")
                .addObject("editEmployeeModel", mapper.toEditEmployeeModel(existingEmployee));
    }

    @PutMapping(value = "/employees/edit/{id}", consumes = "multipart/form-data")
    public String editEmployee(@PathVariable int id, EditEmployeeModel editEmployeeModel,
                               @RequestParam("photoFile") MultipartFile photoFile,
                               Model model) {

        model.addAttribute("employeeId", id);

        Employee editEmployee = mapper.toEntity(editEmployeeModel);

        if(photoFile != null && !photoFile.isEmpty()){
            editEmployee.setPhoto(service.convertToBase64Photo(photoFile));
        }

        service.addOrUpdateEmployee(editEmployee);
        return "redirect:/employees/"+id;
    }

    @GetMapping("/employees/payslip/{id}")
    public ModelAndView getEmployeePayslip(@PathVariable int id) {
        Employee employee = service.getEmployeeById(id);
        return new ModelAndView("payslip")
                .addObject("payslip", employee);
    }

    @GetMapping("/employees/payslip/edit/{id}")
    public ModelAndView showEditEmployeePayslipForm(@PathVariable int id) {
        Employee employee = service.getEmployeeById(id);
        return new ModelAndView("edit-employee-payslip")
                .addObject("payslip", mapper.toEditEmployeeModel(employee));
    }

    @PutMapping(value = "/employees/payslip/edit/{id}", consumes = "multipart/form-data")
    public String editEmployeePayslip(@PathVariable int id,
                                      EditEmployeeModel payslip) {

        Employee editEmployeePayslip = mapper.toEntity(payslip);

        service.addOrUpdateEmployee(editEmployeePayslip);
        return "redirect:/employees/payslip/"+id;
    }

    @GetMapping("/export/csv")
    public StreamingResponseBody exportEmployeesAsCSV(HttpServletResponse response,
                                                      @RequestParam(name = "firstName", required = false) String firstName,
                                                      @RequestParam(name = "lastName", required = false) String lastName,
                                                      @RequestParam(name = "gender", required = false) String gender,
                                                      @RequestParam(name = "position", required = false) String position,
                                                      @RequestParam(name = "hireDate", required = false) String hireDate,
                                                      @RequestParam(name = "departureDate", required = false) String departureDate,
                                                      @RequestParam(name = "sort", defaultValue = "") String sort) {
        List<Employee> employees = service.customSearch(firstName, lastName, gender, position, hireDate, departureDate, sort);
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=\"employees.csv\"");

        return outputStream -> {
            OutputStreamWriter writer = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
            writer.write("Id,Nom,Prenom,Genre,Fonction,DateEmbauche,DateDepart\n");

            for (Employee employee : employees) {
                writer.write(
                        employee.getId() + "," +
                                "\"" + employee.getLastName() + "\"," +
                                "\"" + employee.getFirstName() + "\"," +
                                employee.getGender() + "," +
                                "\"" + employee.getPosition() + "\"," +
                                employee.getHireDate() + "," +
                                (employee.getDepartureDate() != null ? employee.getDepartureDate() : "") + "\n"
                );
            }

            writer.flush();
        };
    }

}
