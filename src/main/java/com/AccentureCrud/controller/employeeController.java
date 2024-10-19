package com.AccentureCrud.controller;

import com.AccentureCrud.entity.Employee;
import com.AccentureCrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class employeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/getAllEmployee")
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }
    @GetMapping("/getEmployeeById/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }
}
