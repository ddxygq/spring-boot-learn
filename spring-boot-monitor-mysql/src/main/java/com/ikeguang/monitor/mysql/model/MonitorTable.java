package com.ikeguang.monitor.mysql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @ Author: keguang
 * @ Date: 2019/7/25 10:50
 * @ version: v1.0.0
 * @ description:
 */
@Entity
public class MonitorTable {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, unique = true)
    private String tableName;

    @Column(nullable = false)
    private String dateColumnName;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String realtime;

    @Column(nullable = true)
    private String hourColumnName;

    public MonitorTable() {
    }

    public MonitorTable(String tableName, String dateColumnName, String status, String realtime, String hourColumnName) {
        this.tableName = tableName;
        this.dateColumnName = dateColumnName;
        this.status = status;
        this.realtime = realtime;
        this.hourColumnName = hourColumnName;
    }

    @Override
    public String toString() {
        return "MonitorTable{" +
                "id=" + id +
                ", tableName='" + tableName + '\'' +
                ", dateColumnName='" + dateColumnName + '\'' +
                ", status='" + status + '\'' +
                ", realtime='" + realtime + '\'' +
                ", hourColumnName='" + hourColumnName + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getDateColumnName() {
        return dateColumnName;
    }

    public void setDateColumnName(String dateColumnName) {
        this.dateColumnName = dateColumnName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRealtime() {
        return realtime;
    }

    public void setRealtime(String realtime) {
        this.realtime = realtime;
    }

    public String getHourColumnName() {
        return hourColumnName;
    }

    public void setHourColumnName(String hourColumnName) {
        this.hourColumnName = hourColumnName;
    }
}
