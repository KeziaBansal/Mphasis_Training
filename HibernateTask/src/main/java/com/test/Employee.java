package com.test;

import jakarta.persistence.Entity;

@Entity
public class Employee extends Person {

    private String department;

    public Employee() {}
    public Employee(String name, String department) {
        super(name);
        this.department = department;
    }
}
