package com.u4.projectmanagement.dao;

import com.u4.projectmanagement.entities.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ProjectRepository extends CrudRepository<Project, Long> {
    @Override
    public List<Project> findAll();
}
