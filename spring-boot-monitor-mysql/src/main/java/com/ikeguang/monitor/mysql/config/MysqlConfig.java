package com.ikeguang.monitor.mysql.config;

import org.hibernate.dialect.MySQL5Dialect;
import org.springframework.stereotype.Component;

/**
 * @ Author: keguang
 * @ Date: 2019/7/16 9:58
 * @ version: v1.0.0
 * @ description: 解决hibernate自动建表字符集为latin不能插入中文的问题。
 */
@Component
@SuppressWarnings("deprecation")
public class MysqlConfig extends MySQL5Dialect{

    @Override
    public String getTableTypeString() {
        return "ENGINE=InnoDB DEFAULT CHARSET=utf8";
    }
}
