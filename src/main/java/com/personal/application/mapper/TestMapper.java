package com.personal.application.mapper;

import com.personal.application.pojo.UserInfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TestMapper {

    List<UserInfo> searchUserInfo();
}
