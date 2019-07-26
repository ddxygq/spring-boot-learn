package com.ikeguang.monitor.mysql.service.impl;

import com.ikeguang.monitor.mysql.model.MonitorTable;
import com.ikeguang.monitor.mysql.repository.MonitorTableRepository;
import com.ikeguang.monitor.mysql.service.MonitorTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ Author: keguang
 * @ Date: 2019/7/25 11:21
 * @ version: v1.0.0
 * @ description:
 */
@Service
public class MonitorTableServiceImpl implements MonitorTableService {

    @Autowired
    private MonitorTableRepository monitorTableRepository;


    @Override
    public List<MonitorTable> getMonitorTableList() {
        return monitorTableRepository.findAll();
    }

    @Override
    public List<MonitorTable> findByStatusAndRealtime(String status, String realtime) {
        return monitorTableRepository.findByStatusAndRealtime(status, realtime);
    }


    @Override
    public MonitorTable findMonitorTableById(Long id) {
        return monitorTableRepository.findById(id).orElse(null);
    }

    @Override
    public MonitorTable findByTableName(String tableName) {
        return monitorTableRepository.findByTableName(tableName);
    }

    @Override
    public void edit(MonitorTable monitorTable) {
        monitorTableRepository.save(monitorTable);
    }

    @Override
    public void save(MonitorTable monitorTable) {
        monitorTableRepository.save(monitorTable);
    }

    @Override
    public void deleteById(long id) {
        monitorTableRepository.deleteById(id);
    }

}
