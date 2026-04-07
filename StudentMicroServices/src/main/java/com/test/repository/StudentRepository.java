package com.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.entity.Student;


public interface StudentRepository extends JpaRepository<Student, Integer>{

}
