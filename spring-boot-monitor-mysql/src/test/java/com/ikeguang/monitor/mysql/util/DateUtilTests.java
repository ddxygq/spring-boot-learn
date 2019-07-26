package com.ikeguang.monitor.mysql.util;

import org.junit.Test;

/**
 * @ Author: keguang
 * @ Date: 2019/7/26 16:51
 * @ version: v1.0.0
 * @ description:
 */
public class DateUtilTests {

    @Test
    public void test(){
        String dateHour = DateUtils.getDayHour(0, 0);
        System.out.println(dateHour);
    }
}
