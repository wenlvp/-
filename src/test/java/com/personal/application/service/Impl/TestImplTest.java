package com.personal.application.service.Impl;

import com.personal.application.mapper.TestMapper;
import com.personal.application.pojo.UserInfo;
import com.personal.application.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestImplTest {
    @Autowired
    private TestService testService;
    @Autowired
    private TestMapper testMapper;

    @Test
    public void searchUserInfo() {
        List<UserInfo> userInfoList = testMapper.searchUserInfo();
        System.out.println(userInfoList);

    }
}