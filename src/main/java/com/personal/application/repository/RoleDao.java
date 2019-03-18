package com.personal.application.repository;

import com.personal.application.pojo.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role,String> {
}
