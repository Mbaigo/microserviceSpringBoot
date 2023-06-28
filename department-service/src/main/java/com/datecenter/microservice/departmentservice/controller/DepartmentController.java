package com.datecenter.microservice.departmentservice.controller;

import com.datecenter.microservice.departmentservice.model.Department;
import com.datecenter.microservice.departmentservice.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
    @Autowired
    private DepartmentRepository departmentRepository;

    public DepartmentController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
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

}
