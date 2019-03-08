package com.personal.application.util;

import java.math.BigDecimal;

/**
 * 转化工具类
 * */
public class ConvertUtils{
    public static int ToInt(String str){
        return Integer.parseInt(str);
    }
    public static double ToDouble(String str){
        return Double.parseDouble(str);
    }
    public static BigDecimal ToBigDecimal(String str){
        return new BigDecimal(str);
    }

}
