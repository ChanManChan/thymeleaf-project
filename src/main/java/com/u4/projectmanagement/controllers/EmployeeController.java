package com.u4.projectmanagement.controllers;

import com.u4.projectmanagement.dao.EmployeeRepository;
import com.u4.projectmanagement.entities.Employee;
import com.u4.projectmanagement.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public String displayEmployees(Model model) {
        List<Employee> employees = employeeService.getAll();

        model.addAttribute("employees", employees);

        return "employees/list-employees";
    }

    @GetMapping("/new")
    public String displayEmployeeForm(Model model) {
        Employee anEmployee = new Employee();

        model.addAttribute("employee", anEmployee);
        return "employees/new-employee";
    }

    @PostMapping("/save")
    public String createEmployeeForm(Model model, @Valid Employee employee, Errors errors) {
        if(errors.hasErrors()) {
            return "employees/new-employee";
        }
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @GetMapping("/update")
    public String displayEmployeeUpdateForm(@RequestParam("id") long empId, Model model) {
        Employee employee = employeeService.findByEmployeeId(empId);

        model.addAttribute("employee", employee);

        return "employees/new-employee";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("id") long empId, Model model) {
        Employee employee = employeeService.findByEmployeeId(empId);
        employeeService.delete(employee);
        return "redirect:/employees";
    }
}
