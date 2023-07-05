package com.datecenter.microservice.departmentservice.controller;

import com.datecenter.microservice.departmentservice.client.EmployeeClient;
import com.datecenter.microservice.departmentservice.model.Department;
import com.datecenter.microservice.departmentservice.repository.DepartmentRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeClient employeeClient;

    public DepartmentController(DepartmentRepository departmentRepository, EmployeeClient employeeClient) {
        this.departmentRepository = departmentRepository;
        this.employeeClient = employeeClient;
    }

    @PostMapping
    public Department addDepartment(@RequestBody Department department){
        LOGGER.info("Department add: ", department);
        return departmentRepository.add(department);
    }
    @GetMapping
    public List<Department> getAllDepartment(){
        LOGGER.info("Department findAll ");
        return departmentRepository.findAll();
    }
    @GetMapping("{id}")
    public Department getById(@PathVariable Long id){
        LOGGER.info("Department findById: ", id);
        return departmentRepository.findById(id);
    }
//liste des departements avec leurs employees
    @GetMapping("/with-employees")
    public List<Department> getAllDepartmentWithEmployees(){
        LOGGER.info("Department findAll ");
      List<Department> departmentList= departmentRepository.findAll();
      departmentList.forEach(department -> department.setEmployes(employeeClient.getByDepartment(department.getId())));
        return departmentList;
    }

}
