package com.ikeguang.monitor.mysql.task;

import com.ikeguang.monitor.mysql.model.MonitorTable;
import com.ikeguang.monitor.mysql.service.MailService;
import com.ikeguang.monitor.mysql.service.MonitorTableService;
import com.ikeguang.monitor.mysql.util.Configuration;
import com.ikeguang.monitor.mysql.util.DateUtils;
import com.ikeguang.monitor.mysql.util.MysqlUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ Author: keguang
 * @ Date: 2019/7/25 16:55
 * @ version: v1.0.0
 * @ description:
 */
@Component
public class SchedulerTask {

    private static final Logger logger = LoggerFactory.getLogger(SchedulerTask.class.getSimpleName());

    // 邮件发送服务
    @Autowired
    private MailService mailService;

    @Resource
    private MonitorTableService monitorTableService;

    /**
     * 读取配置文件
     */
    private static String configFile = "config/config.xml";
    private static Map<String, String> config = Configuration.initConfig(configFile);

    // 状态为1，表示启用中，否则启用
    private static final String STATUS = "1";

    // 邮件发送次数
    private static final int MAIL_MAX_COUNT = 10;
    // 邮件发送一定次数后，停止发送
    private static Map<String, Integer> realtimeMailCount = new HashMap<>();

    /**
     * 离线任务每天11:10分检测一次
     */
    // @Scheduled(cron = "*/10 * * * * ?")
    @Scheduled(cron = "0 10 11 * * ?")
    private void offTask(){

        // 离线通常是获取昨天时间
        String dateStr = DateUtils.getDay(1);
        String realtime = "0";

        Connection connection = MysqlUtils.getConnection();

        List<MonitorTable> monitorTables = monitorTableService.findByStatusAndRealtime(STATUS, realtime);
        for (MonitorTable monitorTable : monitorTables){
            String sql = "select 1 from " + monitorTable.getTableName() + " where " + monitorTable.getDateColumnName() + " = ? limit 1";
            try {
                PreparedStatement ps = connection.prepareStatement(sql);
                // System.out.println("dateStr => " + dateStr);
                ps.setString(1, dateStr);
                ResultSet resultSet = ps.executeQuery();
                if(!resultSet.next()){
                    // 发送邮件通知
                    String[] to = config.get("monitor-mailTo").split(",");
                    for(String receiver : to){
                        mailService.sendMail(receiver, "离线job 异常 =>" + monitorTable.getTableName(), "离线job 异常 =>" + monitorTable.getTableName());
                    }

                    logger.info("job issue " + monitorTable.getTableName());
                }else {
                    logger.info("off valid ...");
                    // System.out.println("off valid ...");
                }

                if(resultSet != null){
                    resultSet.close();
                }

                if(ps != null){
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                logger.error(e.getMessage());
            }
        }

        if(connection != null){
            try{
                connection.close();
            }catch (SQLException e){
                logger.error("close conn SQLException", e.getMessage());
            }

        }

    }

    /**
     * 实时程序，10分钟检测一次
     */
    @Scheduled(cron = "* 10 * * * ?")
    private void realtimeTask(){

        // 实时需要获取今天的时间
        String timeStr = DateUtils.getExacFormatTime(0, 0, 0);
        String dateStr = timeStr.substring(0, 10);
        String hourStr = timeStr.substring(11, 13);
        String minStr = timeStr.substring(14, 16);

        // 每天晚上23点，将realtimeMailCount清空，第二天重新计数
        if("23".equals(hourStr) && Integer.valueOf(minStr) > 30){
            realtimeMailCount.clear();
            logger.info("=> " + timeStr + " clear realtimeMailCount.");
        }

        String realtime = "1";

        Connection connection = MysqlUtils.getConnection();

        List<MonitorTable> monitorTables = monitorTableService.findByStatusAndRealtime(STATUS, realtime);
        for (MonitorTable monitorTable : monitorTables){
            String sql = "select 1 from " + monitorTable.getTableName() + " where " + monitorTable.getDateColumnName() + " = ? and "
                    + monitorTable.getHourColumnName() + " = ? limit 1";
            // System.out.println(sql);
            try {
                PreparedStatement ps = connection.prepareStatement(sql);

                ps.setString(1, dateStr);
                ps.setString(2, hourStr);
                ResultSet resultSet = ps.executeQuery();
                if(!resultSet.next()){
                    int cou = realtimeMailCount.getOrDefault(monitorTable.getTableName(), 0);
                    if(cou < MAIL_MAX_COUNT){
                        // 发送邮件通知
                        String[] to = config.get("monitor-mailTo").split(",");
                        for(String receiver : to){
                            mailService.sendMail(receiver, "实时 job 异常 =>" + monitorTable.getTableName(), "实时 job 异常 =>" + monitorTable.getTableName());
                        }
                        logger.info("job issue " + monitorTable.getTableName());
                        realtimeMailCount.put(monitorTable.getTableName(), ++cou);
                    }


                }else {
                    logger.info("realtime valid ...");
                    // System.out.println("realtime valid ...");
                }

                if(resultSet != null){
                    resultSet.close();
                }

                if(ps != null){
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                logger.error(e.getMessage());
            }
        }

        if(connection != null){
            try{
                connection.close();
            }catch (SQLException e){
                logger.error("close conn SQLException", e.getMessage());
            }

        }
    }

}
