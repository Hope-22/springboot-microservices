package com.microserviceproject.departmentservice.service.impl;

import com.microserviceproject.departmentservice.dto.DepartmentDto;
import com.microserviceproject.departmentservice.entity.Department;
import com.microserviceproject.departmentservice.repository.DepartmentRepository;
import com.microserviceproject.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;


    @Override
    public DepartmentDto  saveDepartment(DepartmentDto departmentDto) {

        //convert department dto to department jpa entity.
        Department department = new Department(

                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()

        );

        Department savedDepartment =  departmentRepository.save(department);

        //convert department jpa entity to department dto.

       DepartmentDto savedDepartmentDto = new DepartmentDto(

               savedDepartment.getId(),
               savedDepartment.getDepartmentName(),
               savedDepartment.getDepartmentDescription(),
               savedDepartment.getDepartmentCode()
       );
        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {

        Department department = departmentRepository.findByDepartmentCode(departmentCode);

        DepartmentDto departmentDto = new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()
        );

        return departmentDto;
    }
}
