package com.datecenter.microservice.departmentservice.repository;

import com.datecenter.microservice.departmentservice.model.Department;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentRepository /*extends JpaRepository<Department, Long>*/ {
    private List<Department> departmentList = new ArrayList<>();

    public Department add(Department department){
        departmentList.add(department);
        return  department;
    }

    public Department findById(Long id){
        return departmentList.stream().filter(dep -> dep.getId().equals(id)).findFirst().orElseThrow();
    }

    public  List<Department> findAll(){
        return departmentList;
    }
}
