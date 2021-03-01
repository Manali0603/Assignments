package com.maersk.spring.springExample.controller;

import com.google.gson.Gson;
import com.maersk.spring.springExample.dto.Employee;
import com.maersk.spring.springExample.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class sampleController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private Employee employee;
    @Autowired
    private Gson gson;

    @RequestMapping("/home")
    public String sampleHome() {
        employee.setAge(7);
        employee.setName("MANALI");
        employeeService.print();
        return gson.toJson(employee);
    }

    @Bean
    public EmployeeService getEmployeeService() {
        return new EmployeeService();
    }


}
