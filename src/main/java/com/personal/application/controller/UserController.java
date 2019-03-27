package com.personal.application.controller;

import com.personal.application.VO.ResultVO;
import com.personal.application.common.Constant;
import com.personal.application.dto.CollectionDto;
import com.personal.application.pojo.UserInfo;
import com.personal.application.service.CollectionService;
import com.personal.application.service.UserService;
import com.personal.application.util.CheckUtils;
import com.personal.application.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private CollectionService collectionService;

    ResultVO resultVO = new ResultVO();
    @PostMapping("judgeLogin")
    public ResultVO judgeLogin( HttpServletRequest request){
        HttpSession session = request.getSession();
        if (CheckUtils.isEmpty(session.getAttribute(Constant.LOGIN_ID))){
            resultVO.setSuccess(false);
        }else {
            resultVO.setSuccess(true);
            resultVO.setData(session.getAttribute(Constant.LOGIN_ID).toString());
        }
        return resultVO;
    }
    @PostMapping("login")
    public ResultVO login(@RequestParam(value = "userId") String userId,
                          @RequestParam(value = "pwd") String pwd,
                          HttpServletRequest request){
        HttpSession session = request.getSession();
        Optional<UserInfo> userInfo = userService.findUserById(userId);
        if(userInfo.isPresent()){
            String password = userInfo.get().getPassword();
            if(password.equals(pwd)){
                session.setAttribute("userId",userId);
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

    @PostMapping("findCollectionBy")
    public ResultVO changeAgreeNum(HttpServletRequest request,
                                   @RequestParam(value = "newsType",required = false) Integer newsType,
                                   @RequestParam(value = "pageSize",required = false) Integer pageSize,
                                   @RequestParam(value = "pageIndex",required = false) Integer pageIndex){
        String userId = request.getSession().getAttribute("userId").toString();
        int startRow = (pageIndex-1) * pageSize ;
        CollectionDto dto = new CollectionDto(userId,newsType,startRow,pageSize);

        List<CollectionDto> list =collectionService.findCollectionByUserId( dto);
        resultVO.beSuccess(list);
        return  resultVO;
    }
}
