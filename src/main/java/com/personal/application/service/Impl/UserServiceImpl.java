package com.personal.application.service.Impl;

import com.personal.application.pojo.UserInfo;
import com.personal.application.repository.UserRepository;
import com.personal.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<UserInfo> findUserById(String userId) {
        return userRepository.findById(userId);
    }

    @Override
    public void save(UserInfo userInfo) {
        userRepository.save(userInfo);
    }
}
