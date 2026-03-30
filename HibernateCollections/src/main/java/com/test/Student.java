package com.test;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="students")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String std_name;
	private String std_college;
	private List<String> skills;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStd_name() {
		return std_name;
	}
	public void setStd_name(String std_name) {
		this.std_name = std_name;
	}
	public String getStd_college() {
		return std_college;
	}
	public void setStd_college(String std_college) {
		this.std_college = std_college;
	}
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", std_name=" + std_name + ", std_college=" + std_college + ", skills=" + skills
				+ "]";
	}
	
	
}
