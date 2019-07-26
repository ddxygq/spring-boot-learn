package com.ikeguang.monitor.mysql.repository;

import com.ikeguang.monitor.mysql.model.MonitorTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ Author: keguang
 * @ Date: 2019/7/25 11:10
 * @ version: v1.0.0
 * @ description:
 */
public interface MonitorTableRepository extends JpaRepository<MonitorTable, Long> {

    /**
     * 根据表名查询
     * @param tableName
     * @return MonitorTable对象
     */
    MonitorTable findByTableName(String tableName);

    /**
     * 根据是否启用状态查询
     * @param status 该监控是否启用
     * @return
     */
    List<MonitorTable> findByStatus(String status);

    List<MonitorTable> findByStatusAndRealtime(String status, String realtime);
}
