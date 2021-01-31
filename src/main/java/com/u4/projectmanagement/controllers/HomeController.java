package com.u4.projectmanagement.controllers;

import com.u4.projectmanagement.dao.EmployeeRepository;
import com.u4.projectmanagement.dao.ProjectRepository;
import com.u4.projectmanagement.entities.Employee;
import com.u4.projectmanagement.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String displayHome(Model model) {
        List<Project> projects = projectRepository.findAll();
        List<Employee> employees = employeeRepository.findAll();

        model.addAttribute("projects", projects);
        model.addAttribute("employees", employees);

        return "main/home";
    }
}
