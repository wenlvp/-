package com.personal.application.service.Impl;

import com.personal.application.mapper.EmployeeMapper;
import com.personal.application.pojo.Employee;
import com.personal.application.repository.EmployeeRepository;
import com.personal.application.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public Optional<Employee> findEmpById(String empId) {
        return employeeRepository.findById(empId);
    }
    @Override
    public Employee addAndChangeEmployee(Employee employee) {

        return employeeRepository.save(employee);

    }

    @Override
    public List<Employee> findEmpInfo() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> findEmpInfoBy(Employee employee) {
        return employeeMapper.findEmployeeBy(employee);
    }

    @Override
    public boolean deleteEmployee(String empId) {
        return employeeMapper.delEmployeeById(empId);
    }
}
