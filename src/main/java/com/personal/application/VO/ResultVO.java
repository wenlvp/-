package com.personal.application.VO;

import lombok.Data;

@Data
public class ResultVO<T> {
    //返回值
    private boolean success = false;
    //返回信息
    private String message = null;
    //需要返回前台数据
    private T Data = null;
    //拦截器验证值
    private boolean login = true;

}
