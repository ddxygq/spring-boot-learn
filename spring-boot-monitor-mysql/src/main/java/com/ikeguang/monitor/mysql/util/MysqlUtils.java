package com.ikeguang.monitor.mysql.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.Map;

/**
 * @ Author: keguang
 * @ Date: 2019/7/8 19:09
 * @ version: v1.0.0
 * @ description: mysql 简单工具类
 */
public class MysqlUtils {

    private static Logger logger = LoggerFactory.getLogger(MysqlUtils.class.getSimpleName());

    /**
     * 读取配置文件
     */
    private static String configFile = "config/config.xml";
    private static  Map<String, String> config = Configuration.initConfig(configFile);

    private static String url = config.get("mysql-url");
    private static String username = config.get("mysql-username");
    private static String password = config.get("mysql-password");

    static {
        // String driver = "com.mysql.jdbc.Driver";
        String driver = "com.mysql.cj.jdbc.Driver";
        try{
            Class.forName(driver);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 获取mysql连接
     * @return
     */
    public static Connection getConnection() {

        try{
            System.out.println("url => " + url);
            return DriverManager.getConnection(url,username,password);
        }catch (SQLException e){
            e.printStackTrace();
            logger.error("get mysql connect SQLException",e.getMessage());
        }
        return null;

    }

    /**
     * 关闭连接
     * @param conn
     * @param stmt
     * @param rs
     */
    public static void close(Connection conn, Statement stmt, ResultSet rs){
        //关闭ResultSet对象
        if(rs != null){
            try{
                // 关闭rs，设置rs=null，因为java会优先回收值为null的变量
                rs.close();
            }catch(SQLException e){
                e.printStackTrace();
                throw new RuntimeException();
            }
        }

        // 关闭Statement对象，PrepareStatement和CallableStatement都是Statement的子接口，所以这里只需要有关闭Statement对象的方法就可以了
        if(stmt != null){
            try{
                stmt.close();
            }catch(SQLException e){
                e.printStackTrace();
                throw new RuntimeException();
            }
        }
        //关闭Connection对象
        if(conn != null){
            try{
                conn.close();
            }catch(SQLException e){
                e.printStackTrace();
                throw new RuntimeException();
            }
        }
    }
}
