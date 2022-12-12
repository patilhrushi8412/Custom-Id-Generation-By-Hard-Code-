package com.te.officeSystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.officeSystem.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

 Optional<Employee> findByEmployeeId(String empId);

}
