package com.personal.application.controller;

import com.personal.application.VO.ResultVO;
import com.personal.application.pojo.UserInfo;
import com.personal.application.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;

    @PostMapping("search")
    public ResultVO test(HttpServletRequest request){

        ResultVO resultVO = new ResultVO();
        List<UserInfo> list = testService.searchUserInfo();
        resultVO.setData(list);
        HttpSession session = request.getSession();
        System.out.println("session:"+session.getAttribute("userId"));
        resultVO.setSuccess(true);
        return resultVO;
    }
}
