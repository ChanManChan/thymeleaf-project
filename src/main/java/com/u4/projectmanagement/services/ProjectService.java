package com.u4.projectmanagement.services;

import com.u4.projectmanagement.dao.ProjectRepository;
import com.u4.projectmanagement.dto.ProjectsStatus;
import com.u4.projectmanagement.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    public Project save(Project project) {
        return projectRepository.save(project);
    }

    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    public List<ProjectsStatus> getProjectStatus() {
        return projectRepository.projectsStatus();
    }
}
