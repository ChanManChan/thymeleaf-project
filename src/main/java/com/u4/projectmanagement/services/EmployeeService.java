package com.u4.projectmanagement.services;

import com.u4.projectmanagement.dao.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    // 3> Field injection
    @Autowired
    EmployeeRepository employeeRepository;

    // 1> Constructor injection
    //    public EmployeeService(EmployeeRepository employeeRepository) {
    //        this.employeeRepository = employeeRepository;
    //    }

    // 2> Setter injection
    //    @Autowired
    //    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
    //        this.employeeRepository = employeeRepository;
    //    }

    // we have two implementations, they are both going to be loaded into the spring context, and we are going to run
    // into a situation where they are both going to compete to be injected.
    //    @Qualifier("staffRepositoryImpl1")
    //    @Autowired
    //    IStaffRepository iStaffRepository;

    //    public EmployeeService(@Qualifier("staffRepositoryImpl1") IStaffRepository iStaffRepository) {
    //        this.iStaffRepository = iStaffRepository;
    //    }
}
