package com.u4.projectmanagement.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.u4.projectmanagement.dao.EmployeeRepository;
import com.u4.projectmanagement.dao.ProjectRepository;
import com.u4.projectmanagement.dto.EmployeeProject;
import com.u4.projectmanagement.dto.ProjectsStatus;
import com.u4.projectmanagement.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String displayHome(Model model) throws JsonProcessingException {
        Map<String, Object> map = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();

        List<Project> projects = projectRepository.findAll();
        List<EmployeeProject> employeesProjectCount = employeeRepository.employeeProjects();
        List<ProjectsStatus> projectsStatuses = projectRepository.projectsStatus();

        String jsonString = objectMapper.writeValueAsString(projectsStatuses);

        model.addAttribute("projectsStatuses", jsonString);
        model.addAttribute("projects", projects);
        model.addAttribute("employeesProjectCount", employeesProjectCount);

        return "main/home";
    }
}
