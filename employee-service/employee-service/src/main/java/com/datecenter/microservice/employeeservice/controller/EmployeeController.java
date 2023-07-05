package com.datecenter.microservice.employeeservice.controller;

import com.datecenter.microservice.employeeservice.model.Employee;
import com.datecenter.microservice.employeeservice.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/employees")
public class EmployeeController {
    private EmployeeRepository employeeRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @PostMapping
    public Employee addEmploye(@RequestBody Employee e){
        LOGGER.info("Department add: ", e);
         employeeRepository.addEmployee(e);
        return e;
    }

    @GetMapping
    public List<Employee> findAll(){
        LOGGER.info("Find all");
        return employeeRepository.getAllEmployee();
    }
    @GetMapping("{id}")
    public Employee getById(@PathVariable Long id){
        return employeeRepository.getById(id);
    }
@GetMapping("/searchByEmail")
    public Employee getByEmail(@RequestParam("email") String email){
        return employeeRepository.getByEmail(email);
    }

    @GetMapping("/searchByFirstName")
    public List<Employee> getByFirstName(@RequestParam("firstName") String firstName){
        return employeeRepository.getByFirstName(firstName);
    }

    @GetMapping("/searchByLastName")
    public List<Employee> getByLastName(@RequestParam("lastName") String lastName){
        return employeeRepository.getByLastName(lastName);
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> getByDepartment(@PathVariable("departmentId") Long departmentId){
        return employeeRepository.getByDepartment(departmentId);
    }

    @DeleteMapping("{id}")
    public boolean deleteEmployee(@PathVariable("id") Long id){
        employeeRepository.deletById(id);
        return true;
    }





}
