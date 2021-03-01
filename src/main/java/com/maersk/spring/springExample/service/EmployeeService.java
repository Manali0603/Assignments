package com.maersk.spring.springExample.service;

import com.maersk.spring.springExample.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class EmployeeService {
    @Autowired
    Employee emp;

    public void print() {
        System.out.println(emp.getName());
        System.out.println(emp.getAge());
    }
}
