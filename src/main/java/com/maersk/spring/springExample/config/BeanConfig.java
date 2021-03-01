package com.maersk.spring.springExample.config;

import com.google.gson.Gson;
import com.maersk.spring.springExample.dto.Employee;
import com.maersk.spring.springExample.service.EmployeeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public Employee getEmployee() {
        return new Employee();
    }

    @Bean
    public EmployeeService getEmployeeService() {
        return new EmployeeService();
    }

    @Bean
    public Gson getGson() {
        return new Gson();
    }
}
