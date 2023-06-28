package com.datecenter.microservice.departmentservice.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class Department {
    private Long id;
    private String code;
    private String name;
    private List<Employee> employes = new ArrayList<>();
}
