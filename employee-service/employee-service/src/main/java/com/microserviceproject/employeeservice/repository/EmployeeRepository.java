package com.microserviceproject.employeeservice.repository;

import com.microserviceproject.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
