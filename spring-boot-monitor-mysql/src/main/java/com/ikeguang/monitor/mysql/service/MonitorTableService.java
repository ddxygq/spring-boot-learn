package com.ikeguang.monitor.mysql.service;

import com.ikeguang.monitor.mysql.model.MonitorTable;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @ Author: keguang
 * @ Date: 2019/7/25 11:20
 * @ version: v1.0.0
 * @ description:
 */
public interface MonitorTableService {

    Page<MonitorTable> getMonitorTableList(int pageNum, int pageSize);

    List<MonitorTable> findByStatusAndRealtime(String status, String realtime);

    MonitorTable findMonitorTableById(Long id);

    MonitorTable findByTableName(String tableName);

    void edit(MonitorTable monitorTable);

    void save(MonitorTable monitorTable);

    void deleteById(long id);
}
