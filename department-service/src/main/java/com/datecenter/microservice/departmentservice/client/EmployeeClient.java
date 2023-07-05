package com.datecenter.microservice.departmentservice.client;

import com.datecenter.microservice.departmentservice.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface EmployeeClient {
    @GetExchange("employees/department/{departmentId}")
    public List<Employee> getByDepartment(@PathVariable("departmentId") Long departmentId);
}
