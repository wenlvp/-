package com.personal.application.controller;

import com.personal.application.VO.ResultVO;
import com.personal.application.pojo.Employee;
import com.personal.application.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
}
