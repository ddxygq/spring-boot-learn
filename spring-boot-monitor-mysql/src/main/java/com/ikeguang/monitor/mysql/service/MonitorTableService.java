package com.ikeguang.monitor.mysql.service;

import com.ikeguang.monitor.mysql.model.MonitorTable;

import java.util.List;

/**
 * @ Author: keguang
 * @ Date: 2019/7/25 11:20
 * @ version: v1.0.0
 * @ description:
 */
public interface MonitorTableService {

    public List<MonitorTable> getMonitorTableList();

    public List<MonitorTable> findMonitorTableByStatus(String status);

    public MonitorTable findMonitorTableById(Long id);

    public void edit(MonitorTable monitorTable);

    public void save(MonitorTable monitorTable);

    public void deleteById(long id);
}
