package com.personal.application.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class UserInfo {
    @Id
    private String userId;
    private String userName;
    private String password;
    private String phone;
    private String email;
    private Integer sex;
    private String identity;
    private String introduce;
    public UserInfo() {
    }

    public UserInfo(String userId,String userName, String phone, String email, Integer sex, String introduce) {
        this.userId = userId;
        this.userName = userName;
        this.phone = phone;
        this.email = email;
        this.sex = sex;
        this.introduce = introduce;
    }

    public UserInfo(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }
}
