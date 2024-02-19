package com.microserviceproject.employeeservice.service;

import com.microserviceproject.employeeservice.dto.APIResponseDto;
import com.microserviceproject.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long employeeId);
}
