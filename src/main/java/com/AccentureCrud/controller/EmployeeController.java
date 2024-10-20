package com.AccentureCrud.controller;

import com.AccentureCrud.entity.Employee;
import com.AccentureCrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/getAllEmployee")
    public ResponseEntity<?> getAllEmployee() {
        var allEmployee = employeeService.getAllEmployee();
        return new ResponseEntity<>(allEmployee, HttpStatus.OK);
    }

    @GetMapping("/getEmployeeById/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Long id) {
        var employee = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
        var savedEmp = employeeService.addEmployee(employee);
        return new ResponseEntity<>(savedEmp, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    @PutMapping("/updateEmployee")
    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) {
        var savedEmp = employeeService.addEmployee(employee);
        return new ResponseEntity<>(savedEmp, HttpStatus.OK);
    }
}
