package com.test;

import jakarta.persistence.Entity;

@Entity
public class Student extends Person {

    private String course;

    public Student() {}
    public Student(String name, String course) {
        super(name);
        this.course = course;
    }
}