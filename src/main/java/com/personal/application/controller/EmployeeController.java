package com.personal.application.controller;

import com.personal.application.VO.ResultVO;
import com.personal.application.pojo.Employee;
import com.personal.application.service.EmployeeService;
import com.personal.application.util.CheckUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping("login")
    public ResultVO login(@RequestParam(value = "empId") String empId,
                          @RequestParam(value = "pwd") String pwd,
                          HttpServletRequest request){
        ResultVO resultVO = new ResultVO();
        HttpSession session = request.getSession();
        Optional<Employee> empInfo = employeeService.findEmpById(empId);
        if(empInfo.isPresent()){
            String password = empInfo.get().getPassword();
            session.setAttribute("empId",empId);
            if(password.equals(pwd)){
                resultVO.setSuccess(true);
            }
        }
        return resultVO;
    }
    @PostMapping("search")
    public List<Employee> findEmployeeInfo(@RequestParam(value = "empId",required = false) String empId,
                                           @RequestParam(value = "empName",required = false) String empName,
                                           @RequestParam(value = "role",required = false) String role){

        Employee employeeCondition = new Employee();
        if (!CheckUtils.isEmpty(empId)){
            employeeCondition.setEmpId(empId);
        }
        if (!CheckUtils.isEmpty(empName)){
            employeeCondition.setEmpName(empName);
        }
        if (!CheckUtils.isEmpty(role)){
            employeeCondition.setRole(role);
        }
        List<Employee>  employeeList  = employeeService.findEmpInfoBy(employeeCondition);


        return employeeList;
    }
    @PostMapping("add")
    public ResultVO addEmployee( @RequestParam(value = "empId") String empId,
                                 @RequestParam(value = "empName") String empName,
                                 @RequestParam(value = "pwd") String pwd,
                                 @RequestParam(value = "role") String role,
                                 @RequestParam(value = "phone") String phone,
                                 @RequestParam(value = "email") String email){
        ResultVO resultVO = new ResultVO();
        Employee employee = new Employee();
        int delFlg = 0;
        employee.setEmpId(empId);
        employee.setEmpName(empName);
        employee.setPassword(pwd);
        employee.setRole(role);
        employee.setPhone(phone);
        employee.setEmail(email);
        employee.setDelFlg(delFlg);
        Optional<Employee> employeeOp = employeeService.findEmpById(employee.getEmpId());
        if (!employeeOp.isPresent()){
            employeeService.addAndChangeEmployee(employee);
            resultVO.setSuccess(true);
        }else{
            resultVO.setMessage("该账号已存在");
        }

        return  resultVO;
    }
    @PostMapping("searchById")
    public ResultVO findEmpInfoById( @RequestParam(value = "empId") String empId){
        ResultVO resultVO = new ResultVO();

        Optional<Employee> employeeOp = employeeService.findEmpById(empId);
        resultVO.setSuccess(true);
        resultVO.setData(employeeOp);
        return  resultVO;
    }
    @PostMapping("change")
    public ResultVO changeEmployee(  @RequestParam(value = "empId") String empId,
                                     @RequestParam(value = "empName") String empName,
                                     @RequestParam(value = "pwd") String pwd,
                                     @RequestParam(value = "role") String role,
                                     @RequestParam(value = "phone") String phone,
                                     @RequestParam(value = "email") String email){
        ResultVO resultVO = new ResultVO();

        int delFlg = 0;
        Employee employee = new Employee(empId,empName,pwd,role,phone,email,delFlg);
        employeeService.addAndChangeEmployee(employee);
        resultVO.setSuccess(true);
        return  resultVO;
    }
    @PostMapping("delete")
    public ResultVO changeEmployee( @RequestParam(value = "empId") String empId){
        ResultVO resultVO = new ResultVO();
        //软删除
        if(employeeService.deleteEmployee(empId)){
            resultVO.setSuccess(true);
        }

        return  resultVO;
    }
}
