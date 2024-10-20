package com.AccentureCrud.service;

import com.AccentureCrud.entity.Employee;

import java.util.List;


public interface EmployeeService {
    List<Employee> getAllEmployee();

    Employee getEmployeeById(Long id);

    Employee addEmployee(Employee employee);

    void deleteEmployee(Long empId);
}
