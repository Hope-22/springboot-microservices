package com.microserviceproject.departmentservice.controller;

import com.microserviceproject.departmentservice.dto.DepartmentDto;
import com.microserviceproject.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    // Build save/create department REST API

    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
       DepartmentDto savedDepartment = departmentService.saveDepartment(departmentDto);

       return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }
      

    // Build GET department API
    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code")  String departmentCode){
       DepartmentDto departmentDto = departmentService.getDepartmentByCode(departmentCode);

       return new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }
}
