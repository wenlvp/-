package com.personal.application.service.Impl;

import com.personal.application.pojo.UserInfo;
import com.personal.application.repository.TestRepository;
import com.personal.application.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestImpl implements TestService {
    @Autowired
    private TestRepository testRepository;
    @Override
    public List<UserInfo> searchUserInfo() {
        return testRepository.findAll();
    }
}
