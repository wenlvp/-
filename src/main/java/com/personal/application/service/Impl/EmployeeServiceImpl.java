package com.personal.application.service.Impl;

import com.personal.application.pojo.Employee;
import com.personal.application.repository.EmployeeRepository;
import com.personal.application.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Optional<Employee> findEmpById(String empId) {
        return employeeRepository.findById(empId);
    }
}
