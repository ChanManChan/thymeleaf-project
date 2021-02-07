package com.u4.projectmanagement.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.u4.projectmanagement.dto.EmployeeProject;
import com.u4.projectmanagement.dto.ProjectsStatus;
import com.u4.projectmanagement.entities.Project;
import com.u4.projectmanagement.example.Car;
import com.u4.projectmanagement.services.EmployeeService;
import com.u4.projectmanagement.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Value("${version}")
    private String version;

    // 1> Field injection
    // @Autowired // create a Bean in the main class or create a configuration class anywhere for this autowired to work
    Car car;

    // 2> Constructor injection
    //    public HomeController(Car car) {
    //        this.car = car;
    //    }

    // 3> Setter injection
    @Autowired
    public void setCar(Car car) {
        this.car = car;
    }

    @Autowired
    ProjectService projectService;

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/")
    public String displayHome(Model model) throws JsonProcessingException {
        Map<String, Object> map = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();

        List<Project> projects = projectService.getAll();
        List<EmployeeProject> employeesProjectCount = employeeService.employeeProjects();
        List<ProjectsStatus> projectsStatuses = projectService.getProjectStatus();

        String jsonString = objectMapper.writeValueAsString(projectsStatuses);

        model.addAttribute("projectsStatuses", jsonString);
        model.addAttribute("projects", projects);
        model.addAttribute("employeesProjectCount", employeesProjectCount);
        model.addAttribute("versionNumber", version);

        return "main/home";
    }
}
