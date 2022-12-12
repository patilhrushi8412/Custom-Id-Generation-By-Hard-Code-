package com.te.officeSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employeedto {

	private String employeeName;
	private int age;
	private String bloodGroup;
	private String email;
	private String designation;
	private long costToCompany;
}
