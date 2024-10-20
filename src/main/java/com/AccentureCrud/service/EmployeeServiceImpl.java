package com.AccentureCrud.service;

import com.AccentureCrud.entity.Employee;
import com.AccentureCrud.repos.EmployeeCrudRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeCrudRepo crudRepo;

    @Override
    public List<Employee> getAllEmployee() {
        return crudRepo.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return crudRepo.findById(id).orElse(null);
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return crudRepo.save(employee);
    }

    @Override
    public void deleteEmployee(Long empId) {
         crudRepo.deleteById(empId);
    }
}
