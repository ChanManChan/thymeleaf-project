package com.u4.projectmanagement.controllers;

import com.u4.projectmanagement.dao.EmployeeRepository;
import com.u4.projectmanagement.dao.ProjectRepository;
import com.u4.projectmanagement.entities.Employee;
import com.u4.projectmanagement.entities.Project;
import com.u4.projectmanagement.services.EmployeeService;
import com.u4.projectmanagement.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public String displayProjects(Model model) {
        List<Project> projects = projectService.getAll();

        model.addAttribute("projects", projects);

        return "projects/list-projects";
    }

    @GetMapping("/new")
    public String displayProjectForm(Model model) {
        Project aProject = new Project();
        List<Employee> employees = employeeService.getAll();

        model.addAttribute("project", aProject);
        model.addAttribute("allEmployees", employees);
        return "projects/new-project";
    }

    @PostMapping("/save")
    public String createProjectForm(Project project, @RequestParam List<Long> employees, Model model) {
        projectService.save(project);

        // this is for @ManyToOne (many employees to one project) relationship only
        // Iterable<Employee> chosenEmployees = employeeRepository.findAllById(employees);
        //
        // for (Employee emp : chosenEmployees) {
        //      emp.setProjects(project);
        //      employeeRepository.save(emp);
        // }

        return "redirect:/projects/new";
    }
}
