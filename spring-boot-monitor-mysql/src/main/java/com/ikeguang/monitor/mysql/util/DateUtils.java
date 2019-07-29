package com.ikeguang.monitor.mysql.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @ Author: keguang
 * @ Date: 2019/7/25 17:59
 * @ version: v1.0.0
 * @ description: 时间工具类
 */
public class DateUtils {
    /**
     * 获取间隔今天天数日期格式化后 例如：今天日期 2019-06-27
     * @param until 1
     * @return 2019-06-26
     */
    public static String getDay(int until){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE,0 - until);
        Date date = cal.getTime();
        SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
        String yes = sp.format(date);
        return yes;
    }

    /**
     * 获取间隔今天天数日期格式化后
     * @param date_ 距离今天天数
     * @param hour_ 距离当前小时数据
     * @return 日期小时
     */
    public static String getDayHour(int date_, int hour_){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE,0 - date_);
        cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY) - hour_);
        Date date = cal.getTime();
        SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd-HH");
        String dayHour = sp.format(date);
        return dayHour;
    }

    /**
     * 获取间隔现在时间格式化后，今天2019-07-29 11:49
     * @param date_ 0
     * @param hour_ 0
     * @param minute_ 0
     * @return 2019-07-29-11-49-40
     */
    public static String getExacFormatTime(int date_, int hour_, int minute_){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE,0 - date_);
        cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY) - hour_);
        Date date = cal.getTime();
        SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String dayHour = sp.format(date);
        return dayHour;
    }
}
