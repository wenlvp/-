package com.personal.application.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

/**
 * 验证工具类
 * */
public class CheckUtils {

    public static boolean isEmpty(Object obj){
        if (obj == null){
            return true;
        }
        return false;
    }
    public static boolean isEmpty(String str){
        return StringUtils.isBlank(str);
    }

    public static boolean isNotEmpty(Object obj){
        return !isEmpty(obj);
    }
    public static boolean isNotEmpty(String str){
        return StringUtils.isBlank(str);
    }
}
