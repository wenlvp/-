package com.personal.application.repository;

import com.personal.application.pojo.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<UserInfo,String> {
}
