package com.personal.application.VO;

import lombok.Data;

@Data
public class ResultVO<T> {
    private final static String SUCCESS_MSG = "操作成功";
    //返回值
    private boolean success = false;
    //返回信息
    private String message = null;
    //需要返回前台数据
    private T data = null;
    //拦截器验证值
    private boolean login = true;

    public boolean isSuccess(T data){
        this.data = data;
        this.success = true;
        this.message = "操作成功";
        return true;
    }

}
