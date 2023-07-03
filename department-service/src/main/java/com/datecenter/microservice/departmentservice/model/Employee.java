package com.datecenter.microservice.departmentservice.model;

public record Employee(Long id, Long departmentId,String name, int age, String position,
                       String firstName, String lastName, String email ) {
}
