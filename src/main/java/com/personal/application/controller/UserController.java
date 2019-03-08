package com.personal.application.controller;

import com.personal.application.VO.ResultVO;
import com.personal.application.pojo.UserInfo;
import com.personal.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@RestController

@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("login")
    public ResultVO login(@RequestParam(value = "userId") String userId,
                          @RequestParam(value = "pwd") String pwd,
                          HttpServletRequest request){
        ResultVO resultVO = new ResultVO();
        HttpSession session = request.getSession();
        Optional<UserInfo> userInfo = userService.findUserById(userId);
        if(userInfo.isPresent()){
            String password = userInfo.get().getPassword();
            session.setAttribute("userId",userId);
            System.out.println(session.getAttribute("userId"));
            if(password.equals(pwd)){
                resultVO.setSuccess(true);
            }
        }
        return resultVO;
    }
    @PostMapping("register")
    public ResultVO add(@RequestParam(value = "userId") String userId,
                        @RequestParam(value = "pwd") String pwd,
                        @RequestParam(value = "phone" ,required = false) String phone,
                        @RequestParam(value = "email" ,required = false) String email,
                        @RequestParam(value = "sex" ,required = false) String sex,
                        @RequestParam(value = "identity",required = false) String identity,
                        @RequestParam(value = "userName",required = false) String userName){
        ResultVO resultVO = new ResultVO();
        Optional<UserInfo> userInfoOp = userService.findUserById(userId);
        if(userInfoOp.isPresent()){
           resultVO.setMessage("该账号已存在");
        }else{
            userService.save(new UserInfo(userId,pwd));
            resultVO.setMessage("注册成功");
            resultVO.setSuccess(true);
        }
        return resultVO;
    }
}
