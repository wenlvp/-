package com.personal.application.service.Impl;

import com.personal.application.mapper.RoleMapper;
import com.personal.application.pojo.EmpMst;
import com.personal.application.pojo.Privilege;
import com.personal.application.pojo.Role;
import com.personal.application.repository.RoleDao;

import com.personal.application.service.RoleService;
import com.personal.application.util.CheckUtils;
import org.aspectj.weaver.Checker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> findRole() {
        return roleDao.findAll();
    }

    @Override
    public List<Privilege> getPrivilegeList() {
        return roleMapper.getPrivilegeList();
    }

    @Override
    public Optional<Role> findRoleById(String roleId) {
        return roleDao.findById(roleId);
    }

    @Override
    public boolean changePrivilege(String checkVal,String roleId) {
        String [] chkVal = checkVal.split("△");
        String menuCode;
        try{
            roleMapper.updateAllActionFlgByRoleId(roleId);
                for (int i = 0;i<chkVal.length;i++){
                    int addNum = 0;
                    int changeNum = 0;
                    menuCode = chkVal[i];
                    EmpMst empMst = roleMapper.getActionFlgBy(roleId,menuCode);
                    if (CheckUtils.isEmpty(empMst)){
                        addNum = roleMapper.addEmpMst(roleId,menuCode);

                    }else {
                        changeNum = roleMapper.updateEmpMst(roleId,menuCode,"0");
                    }
                }
                return true;

        }catch(Exception e){
            System.out.println(e.toString());
            return false;
        }
    }

    @Override
    public boolean addPrivilege(String checkVal, String roleId,String roleName,String description) {
        Role role = new Role(roleId,roleName,description);
        String [] chkVal = checkVal.split("△");
        String menuCode;
        try{
            for (int i = 0;i<chkVal.length;i++){
                int addNum = 0;
                menuCode = chkVal[i];
                addNum = roleMapper.addEmpMst(roleId,menuCode);
            }
            roleDao.save(role);
            return true;

        }catch(Exception e){
            System.out.println(e.toString());
            return false;
        }
    }

    @Override
    public List<EmpMst> findMenuCodeBy(String roleId) {
        return roleMapper.findMenuCodeBy(roleId);
    }

    @Override
    public void delRole(String roleId) {
        roleDao.deleteById(roleId);
    }

    @Override
    public Role addRole(Role role) {
        return roleDao.save(role);
    }
}
