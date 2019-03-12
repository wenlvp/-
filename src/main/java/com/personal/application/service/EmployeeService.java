package com.personal.application.service;

import com.personal.application.pojo.Employee;

import java.util.Optional;

public interface EmployeeService {
    Optional<Employee> findEmpById(String empId);
}
