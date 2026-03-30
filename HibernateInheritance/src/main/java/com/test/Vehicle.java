package com.test;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name="vehicle")
@Inheritance(strategy = InheritanceType.JOINED)
// @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // it will create 3 tables
// @Inheritance(strategy = InheritanceType.SINGLE_TABLE) // it will create single table
/*@DiscriminatorColumn(
		name="vehicle_type",
		discriminatorType=DiscriminatorType.STRING
		)
*/

public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String v_name;
	private int licenseNumber;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getV_name() {
		return v_name;
	}
	public void setV_name(String v_name) {
		this.v_name = v_name;
	}
	public int getLicenseNumber() {
		return licenseNumber;
	}
	public void setLicenseNumber(int licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
	
}
