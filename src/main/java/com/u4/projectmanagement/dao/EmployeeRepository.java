package com.u4.projectmanagement.dao;

import com.u4.projectmanagement.entities.Employee;
import com.u4.projectmanagement.entities.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    @Override
    public List<Employee> findAll();
}
