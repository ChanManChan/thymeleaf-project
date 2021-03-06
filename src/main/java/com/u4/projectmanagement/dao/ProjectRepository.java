package com.u4.projectmanagement.dao;

import com.u4.projectmanagement.dto.ProjectsStatus;
import com.u4.projectmanagement.entities.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {
    @Override
    public List<Project> findAll();

    @Query(
            nativeQuery = true,
            value = "select stage as label, count(*) as value" +
                    " from project" +
                    " group by stage"
    )
    public List<ProjectsStatus> projectsStatus();
}
