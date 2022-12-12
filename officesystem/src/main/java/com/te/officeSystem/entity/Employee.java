package com.te.officeSystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String employeeName; 
	private String employeeId;
	private int age;
	private String bloodGroup;
	private String email;
	private String designation;
	private long costToCompany;
}
