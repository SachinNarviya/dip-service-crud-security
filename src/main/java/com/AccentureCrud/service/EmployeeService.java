package com.AccentureCrud.service;

import com.AccentureCrud.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
     List<Employee> getAllEmployee();

     Employee getEmployeeById(Long id);
}
