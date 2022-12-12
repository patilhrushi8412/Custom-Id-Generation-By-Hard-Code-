package com.te.officeSystem.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.officeSystem.customexception.CustomException;
import com.te.officeSystem.dto.Employeedto;
import com.te.officeSystem.entity.Employee;
import com.te.officeSystem.repository.EmployeeRepo;

@Service
public class ServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo repo;

	@Override
	public Employee addEmployee(Employeedto empDto) {
		try {
			if (empDto == null) {
				throw new CustomException("SomeThing Went Wrong");
			} else {
				Employee emp = new Employee();
				BeanUtils.copyProperties(empDto, emp);
				LocalDate d = LocalDate.now();
				emp.setEmployeeId("TYC0" + d.getMonth().getValue() + d.getYear() + "0" + (repo.findAll().size()+1));
				repo.save(emp);
				return emp;
			}
		} catch (RuntimeException e) {
			throw e;
		}
	}

	@Override
	public Employee getEmployee(String empId) {
		try {
			Optional<Employee> emp = repo.findByEmployeeId(empId);
			if (!emp.isPresent()) {
				throw new CustomException("Which Employee You Want Is Not Present");
			} else {
				return emp.get();
			}
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<Employee> getAllEmployee() {
		try {
			List<Employee> emp = repo.findAll();
			if (emp.isEmpty()) {
				throw new CustomException("No Any Employee Is Present Right Now");
			} else {
				return emp;
			}
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void deleteEmployee(String empId) {
		try {
			Optional<Employee> emp = repo.findByEmployeeId(empId);
			if (!emp.isPresent()) {
				throw new CustomException("Which Employee You Want To Delete Is Not Present");
			} else {
				repo.delete(emp.get());
			}
		} catch (Exception e) {
			throw e;
		}
	}
}
