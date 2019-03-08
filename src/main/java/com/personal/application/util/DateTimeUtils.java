package com.personal.application.util;

import org.apache.commons.lang3.time.DateUtils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.Date;

/**
* 日期工具类
* */
public class DateTimeUtils extends DateUtils {
    private static String YYYY_MM_DD = "yyyy-MM-dd";
    private static String YYYY_MM_DD2 = "yyyy/MM/dd";
    private static String YYYY_MM_DD3 = "yyyyMMdd";
    private static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    private static LocalDateTime currentTime = LocalDateTime.now();
    private static LocalDate localDate = LocalDate.now();
    private static Date date = new Date();
    /**
     * 获取当前日期
     * @param format 要获取当前日期的格式*
     * @return 指定格式的当前日期*/
    public static String getLocalDate(String format){
        String strDate ="";
        if (format.equals(YYYY_MM_DD)){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            strDate = sdf.format(date);
        }
        if (format.equals(YYYY_MM_DD2)){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            strDate = sdf.format(date);
        }
        if (format.equals(YYYY_MM_DD3)){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            strDate = sdf.format(date);
        }

        if (format.equals(YYYY_MM_DD_HH_MM_SS)){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            strDate = sdf.format(date);
        }
        return strDate;
    }

    public static int getYear(){
        return currentTime.getYear();
    }
    public static int getMonth(){
        return localDate.getMonthValue();
    }
    public static int getDay(){
        return currentTime.getDayOfMonth();
    }

}
