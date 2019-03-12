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
    private Integer role;

}
