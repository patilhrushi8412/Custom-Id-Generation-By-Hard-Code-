package com.te.officeSystem.services;

import java.util.List;

import com.te.officeSystem.dto.Employeedto;
import com.te.officeSystem.entity.Employee;

public interface EmployeeService {

	Employee addEmployee(Employeedto empDto);

	Employee getEmployee(String empId);

	List<Employee> getAllEmployee();

	void deleteEmployee(String empId);

}
