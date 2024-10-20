package com.AccentureCrud.controller;

import com.AccentureCrud.entity.Employee;
import com.AccentureCrud.exception.BusinessServiceException;
import com.AccentureCrud.exception.ControllerException;
import com.AccentureCrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/getAllEmployee")
    public ResponseEntity<?> getAllEmployee() {
        try {
            var allEmployee = employeeService.getAllEmployee();
            return new ResponseEntity<>(allEmployee, HttpStatus.OK);
        } catch (BusinessServiceException e) {
            var controllerException = new ControllerException(e.getErrorCode(), e.getErrorMessage());
            return new ResponseEntity<>(controllerException, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            var controllerException = new ControllerException("608",
                    "Something went wrong in controller while fetching the employee list" + e.getMessage());
            return new ResponseEntity<>(controllerException, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getEmployeeById/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Long id) {
        try {
            var employee = employeeService.getEmployeeById(id);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } catch (BusinessServiceException e) {
            var controllerException = new ControllerException(e.getErrorCode(), e.getErrorMessage());
            return new ResponseEntity<>(controllerException, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            var controllerException = new ControllerException("609",
                    "Something went wrong in controller while fetching the employee object" + e.getMessage());
            return new ResponseEntity<>(controllerException, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
        try {
            var savedEmp = employeeService.addEmployee(employee);
            return new ResponseEntity<>(savedEmp, HttpStatus.CREATED);
        } catch (BusinessServiceException e) {
            var controllerException = new ControllerException(e.getErrorCode(), e.getErrorMessage());
            return new ResponseEntity<>(controllerException, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            var controllerException = new ControllerException("610",
                    "Something went wrong in controller while saving the employee object" + e.getMessage());
            return new ResponseEntity<>(controllerException, HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable Long id) {
        try {
            employeeService.deleteEmployee(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (BusinessServiceException e) {
            var controllerException = new ControllerException(e.getErrorCode(), e.getErrorMessage());
            return new ResponseEntity<>(controllerException, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            var controllerException = new ControllerException("611",
                    "Something went wrong in controller while deleting the employee object" + e.getMessage());
            return new ResponseEntity<>(controllerException, HttpStatus.BAD_REQUEST);
        }
    }
}
