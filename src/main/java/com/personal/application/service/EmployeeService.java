package com.personal.application.service;

import com.personal.application.pojo.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Optional<Employee> findEmpById(String empId);
    Employee addAndChangeEmployee(Employee employee);
    List<Employee> findEmpInfo();
    List<Employee> findEmpInfoBy(Employee employee);
    boolean deleteEmployee(String empId);
}
