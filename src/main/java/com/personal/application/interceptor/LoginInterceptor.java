package com.personal.application.interceptor;


import com.alibaba.fastjson.JSONObject;
import com.personal.application.VO.ResultVO;
import com.personal.application.util.CheckUtils;
import com.personal.application.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class LoginInterceptor implements HandlerInterceptor {
    private static List<String> NO_LOGIN_URI = new ArrayList<String>();
    private static String LOGIN_ID = "userId";

    static{
        NO_LOGIN_URI.add("/project/user/login");
        NO_LOGIN_URI.add("/project/user/register");
    }

    @Override
    public boolean preHandle (HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        //System.out.println("---------------------开始进入请求地址拦截----------------------------");
        //响应请求头，实现跨域
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Origin","http://localhost:63342");
        response.setHeader("Access-Control-Allow-Methods","*");
        response.setHeader("Access-Control-Allow-Headers","Origin,Content-Type,Accept,token,X-Requested-With");
        ResultVO result = new ResultVO();
        String uri = request.getRequestURI();
        HttpSession session = request.getSession();
        //无需拦截URI
        if(NO_LOGIN_URI.contains(uri)){
            result.setSuccess(true);
            return true;
        }
        if(NO_LOGIN_URI.contains(uri)){
            result.setSuccess(true);
            return true;
        }
        if (CheckUtils.isEmpty(session.getAttribute(LOGIN_ID))){
            result.setLogin(false);
            result.setMessage("请先登录");
            response.setContentType("application/json; charset=utf-8");
            JSONObject json = (JSONObject) JSONObject.toJSON(result);
            response.getWriter().write(json.toJSONString());
            return false;
        }
        result.setSuccess(true);
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception{

    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o,Exception ex) throws Exception{

    }

}
