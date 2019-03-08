package com.personal.application.service;

import com.personal.application.pojo.UserInfo;

import java.util.Optional;

public interface UserService {
    Optional<UserInfo> findUserById(String userId);
    void save(UserInfo userInfo);
}
