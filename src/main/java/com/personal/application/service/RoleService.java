package com.personal.application.service;



import com.personal.application.pojo.EmpMst;
import com.personal.application.pojo.Privilege;
import com.personal.application.pojo.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    List<Role> findRole();

    List<Privilege> getPrivilegeList();

    Optional<Role> findRoleById(String roleId);

    boolean changePrivilege(String checkVal, String roleId);

    boolean addPrivilege(String checkVal, String roleId, String roleName, String description);

    List<EmpMst> findMenuCodeBy(String roleId);

    void delRole(String roleId);

    Role addRole(Role role);
}
