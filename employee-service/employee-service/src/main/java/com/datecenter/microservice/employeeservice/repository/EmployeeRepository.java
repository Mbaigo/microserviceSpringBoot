package com.datecenter.microservice.employeeservice.repository;

import com.datecenter.microservice.employeeservice.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepository {

    private List<Employee> listEmployees = new ArrayList<>();

    public List<Employee> getAllEmployee(){
        return listEmployees;
    }

    public Employee addEmployee(Employee employee){
        listEmployees.add(employee);
        return employee;
    }

    public  List<Employee> getByDepartment(Long departmentId){
        return  listEmployees.stream().filter(employee -> employee.departmentId().equals(departmentId)).toList();
    }

    public Employee getById(Long id){
        return  listEmployees.stream().filter(empl ->empl.id().equals(id)).findFirst().orElseThrow();
    }

    public List<Employee> getByFirstName(String firstName){
        return  listEmployees.stream()
                                        .filter(employee -> employee.firstName().equals(firstName))
                                            .collect(Collectors.toList());
    }

    public List<Employee> getByLastName(String lastName){
        return listEmployees.stream().filter(employee -> employee.lastName().equals(lastName)).collect(Collectors.toList());
    }

    public Employee getByEmail(String email){
        return listEmployees.stream().filter(employee -> employee.email().equals(email)).findFirst().orElseThrow();
    }

    public boolean deletById(Long id){
        Employee e = getById(id);
        listEmployees.remove(e);
        return true;
    }
}
