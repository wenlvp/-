package com.personal.application.repository;

import com.personal.application.pojo.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,String> {
}
