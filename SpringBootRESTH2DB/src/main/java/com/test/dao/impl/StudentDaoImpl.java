package com.test.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.dao.StudentDao;
import com.test.entity.Student;
import com.test.repository.StudentRepository;

@Repository
public class StudentDaoImpl implements StudentDao{

	@Autowired
	private StudentRepository repository;
	
	@Override
	public Student saveStudent(Student obj) {
		return repository.save(obj);
	}

	@Override
	public Student getStudentById(int id) {
		return repository.findById(id).get();
	}

	@Override
	public Student updateStudentById(Student obj) {
		return repository.save(obj);
	}

	@Override
	public List<Student> deleteStudentById(int id) {
		repository.deleteById(id);
		List<Student> list = repository.findAll();
		return list;
	}

	@Override
	public List<Student> getAllStudents() {
		return repository.findAll();
	}

}
