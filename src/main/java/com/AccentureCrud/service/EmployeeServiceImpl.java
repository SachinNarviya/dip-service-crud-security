package com.AccentureCrud.service;

import com.AccentureCrud.entity.Employee;
import com.AccentureCrud.exception.BusinessServiceException;
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
        List<Employee> empList = null;
        try {
            empList = crudRepo.findAll();
        } catch (Exception e) {
            throw new BusinessServiceException("604",
                    "Something went wrong while fetching the employee list" + e.getMessage());
        }
        if (empList.isEmpty()) {
            throw new BusinessServiceException("605",
                    "No employee found in the database");
        }
        return empList;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        try {
            return crudRepo.findById(id).get();
        } catch (IllegalArgumentException e) {
            throw new BusinessServiceException("606",
                    "Given employee id is null" + e.getMessage());
        } catch (java.util.NoSuchElementException e) {
            throw new BusinessServiceException("607",
                    "No employee found with the given id" + e.getMessage());
        } catch (Exception e) {
            throw new BusinessServiceException("608", "Something went wrong while fetching the employee object" + e.getMessage());
        }
    }

    @Override
    public Employee addEmployee(Employee employee) {
        // Validation should be done in try block
        if (employee.getName().isEmpty() || employee.getName().isBlank()) {
            throw new BusinessServiceException("601",
                    "Please send the proper name,It should not be null");
        }
        try {
            return crudRepo.save(employee);
        } catch (IllegalArgumentException e) {
            throw new BusinessServiceException("602", "Given employee object is null" + e.getMessage());
        } catch (Exception e) {
            throw new BusinessServiceException("603",
                    "Something went wrong while saving the employee object" + e.getMessage());
        }

    }

    @Override
    public void deleteEmployee(Long empId) {
        try {
            crudRepo.deleteById(empId);
        } catch (IllegalArgumentException e) {
            throw new BusinessServiceException("609",
                    "Given employee id is null" + e.getMessage());
        } catch (Exception e) {
            throw new BusinessServiceException("610",
                    "Something went wrong while deleting the employee object" + e.getMessage());
        }
    }
}
