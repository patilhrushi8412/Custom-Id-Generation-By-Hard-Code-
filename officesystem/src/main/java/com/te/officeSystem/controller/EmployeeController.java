package com.te.officeSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.officeSystem.dto.Employeedto;
import com.te.officeSystem.entity.Employee;
import com.te.officeSystem.response.Response;
import com.te.officeSystem.services.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@PostMapping("/addEmployee")
	public ResponseEntity<Response> addEmployee(@RequestBody Employeedto empDto) {
		Employee emp = service.addEmployee(empDto);
		return new ResponseEntity<Response>(new Response(false, "Employee Added Succesfully", emp), HttpStatus.OK);
	}
	
	@GetMapping("/getEmployee/{empId}")
	public ResponseEntity<Response> getEmployee(@PathVariable String empId) {
		Employee emp = service.getEmployee(empId);
		return new ResponseEntity<Response>(new Response(false, "Get Employee Details Succesfully", emp), HttpStatus.OK);
	}
	
	@GetMapping("/getAllEmployee")
	public ResponseEntity<Response> getAllEmployee() {
		List<Employee> emp = service.getAllEmployee();
		return new ResponseEntity<Response>(new Response(false, "Getting All Employee Details Succesfully", emp), HttpStatus.OK);
	}
	
	@GetMapping("/deleteEmployee/{empId}")
	public ResponseEntity<Response> deleteEmployee(@PathVariable String empId) {
		service.deleteEmployee(empId);
		return new ResponseEntity<Response>(new Response(false, "Delete Employee Details Succesfully", null), HttpStatus.OK);
	}
}
