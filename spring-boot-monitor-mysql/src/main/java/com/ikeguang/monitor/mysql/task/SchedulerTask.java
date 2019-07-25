package com.ikeguang.monitor.mysql.task;

import com.ikeguang.monitor.mysql.model.MonitorTable;
import com.ikeguang.monitor.mysql.service.MailService;
import com.ikeguang.monitor.mysql.service.MonitorTableService;
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
import java.util.List;

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

    // 状态为1，表示其用中，否则启用
    private static final String STATUS = "1";

    @Resource
    private MonitorTableService monitorTableService;

    @Scheduled(cron = "*/5 * * * * ?")
    private void task(){

        String dateStr = DateUtils.getDay(1);

        Connection connection = MysqlUtils.getConnection();

        List<MonitorTable> monitorTables = monitorTableService.findMonitorTableByStatus(STATUS);
        for (MonitorTable monitorTable : monitorTables){
            String sql = "select 1 from" + monitorTable.getTableName() + " where " + monitorTable.getColumnName() + " = ? limit 1";
            try {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, dateStr);
                ResultSet resultSet = ps.executeQuery();
                if(!resultSet.next()){
                    mailService.sendMail("keguang@flash.cn", "job issue " + monitorTable.getColumnName(), "job issue =>" + monitorTable.getTableName());
                    logger.info("job issue " + monitorTable.getTableName());
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
