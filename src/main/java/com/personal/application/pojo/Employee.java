package com.personal.application.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Employee {
    @Id
    private String empId;
    private String empName;
    private String password;
    private String role;
    private String phone;
    private String email;
    private int delFlg;

    public Employee() {
    }

    public Employee(String empId, String empName, String password, String role, String phone, String email, int delFlg) {
        this.empId = empId;
        this.empName = empName;
        this.password = password;
        this.role = role;
        this.phone = phone;
        this.email = email;
        this.delFlg = delFlg;
    }
}
