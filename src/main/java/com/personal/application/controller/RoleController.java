package com.personal.application.controller;

import com.personal.application.VO.ResultVO;
import com.personal.application.common.Constant;
import com.personal.application.pojo.EmpMst;
import com.personal.application.pojo.Employee;
import com.personal.application.pojo.Privilege;
import com.personal.application.pojo.Role;
import com.personal.application.service.EmployeeService;
import com.personal.application.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("search")
    public ResultVO getRole(){
        ResultVO resultVO = new ResultVO();
        List<Role> roleList = roleService.findRole();
        resultVO.setData(roleList);
        resultVO.setSuccess(true);
        return resultVO;
    }
    @PostMapping("find")
    public ResultVO getPrivilege(){
        ResultVO resultVO = new ResultVO();
        List<Privilege> privilegeList = roleService.getPrivilegeList();
        resultVO.setData(privilegeList);
        resultVO.setSuccess(true);
        return resultVO;
    }
    @PostMapping("findById")
    public ResultVO findRoleById(@RequestParam(value = "roleId") String roleId){
        ResultVO resultVO = new ResultVO();
        Optional<Role> roleOp = roleService.findRoleById(roleId);
        resultVO.setData(roleOp);

        resultVO.setSuccess(true);
        return resultVO;
    }
    @PostMapping("changePrivilege")
    public ResultVO changePrivilege(@RequestParam(value = "checkVal") String checkVal,
                                    @RequestParam(value = "roleId") String roleId  ){
        ResultVO resultVO = new ResultVO();
        boolean success = roleService.changePrivilege(checkVal,roleId);
        resultVO.setSuccess(success);
        return resultVO;
    }
    @PostMapping("addPrivilege")
    public ResultVO addPrivilege(@RequestParam(value = "checkVal") String checkVal,
                                    @RequestParam(value = "roleId") String roleId,
                                 @RequestParam(value = "roleName") String roleName,
                                 @RequestParam(value = "description") String description){
        ResultVO resultVO = new ResultVO();
        boolean success = roleService.addPrivilege(checkVal,roleId,roleName,description);
        resultVO.setSuccess(success);
        return resultVO;
    }
    @PostMapping("menucode")
    public ResultVO searchMenuCode(HttpSession session){
        ResultVO resultVO = new ResultVO();
        try{
            Optional<Employee> empOp = employeeService.findEmpById(session.getAttribute(Constant.EMP_ID).toString());
            List<EmpMst> empMstList = roleService.findMenuCodeBy(empOp.get().getRole());
            resultVO.setData(empMstList);
            resultVO.setSuccess(true);
            return resultVO;
        }catch(Exception ex){
            resultVO.setMessage(ex.toString());
            return resultVO;
        }

    }
    @PostMapping("/del")
    public ResultVO delRole(@RequestParam(value = "roleId") String roleId){
        ResultVO resultVO = new ResultVO();
        roleService.delRole(roleId);
        resultVO.setSuccess(true);
        return  resultVO;
    }
}
