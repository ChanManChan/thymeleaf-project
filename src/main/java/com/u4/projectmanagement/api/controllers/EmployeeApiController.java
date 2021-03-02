package com.u4.projectmanagement.api.controllers;

import com.u4.projectmanagement.dao.EmployeeRepository;
import com.u4.projectmanagement.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app-api/employees")
public class EmployeeApiController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping
    public Iterable<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeRepository.findById(id).get();
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee create(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @PutMapping(consumes = "application/json")
    public Employee update(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @PatchMapping(path = "/{id}", consumes = "application/json")
    public Employee partialUpdate(@PathVariable Long id, @RequestBody Employee patchEmployee) {
        Employee emp = employeeRepository.findById(id).get();

        if(patchEmployee.getEmail() != null) {
            emp.setEmail(patchEmployee.getEmail());
        }

        if(patchEmployee.getFirstName() != null) {
            emp.setFirstName(patchEmployee.getFirstName());
        }

        if(patchEmployee.getLastName() != null) {
            emp.setLastName(patchEmployee.getLastName());
        }

        return employeeRepository.save(emp);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        try {
            employeeRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
        }
    }
}
