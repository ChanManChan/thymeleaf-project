package com.u4.projectmanagement.dao;

import com.u4.projectmanagement.dto.EmployeeProject;
import com.u4.projectmanagement.entities.Employee;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//@Repository
//@Profile("dev")
public class EmployeeRepository2 implements EmployeeRepository {
    @Override
    public <S extends Employee> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Employee> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Employee> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Employee> findAll() {
        Employee emp1 = new Employee("Nanda", "Gopal", "nandu@test.com");
        Employee emp2 = new Employee("Uber", "Chan", "uber@chan.com");
        Employee emp3 = new Employee("Chan", "chan", "chan@chan.com");

        return Arrays.asList(emp1, emp2, emp3);
    }

    @Override
    public Iterable<Employee> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Employee entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends Employee> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<EmployeeProject> employeeProjects() {
        EmployeeProject employeeProject = new EmployeeProject() {
            @Override
            public String getFirstName() {
                return "Nandu";
            }

            @Override
            public String getLastName() {
                return "Sama";
            }

            @Override
            public int getProjectCount() {
                return 69;
            }
        };

        return Arrays.asList(employeeProject);
    }
}
