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
    private String columnName;

    @Column(nullable = false)
    private String status;

    public MonitorTable(String tableName, String columnName, String status) {
        this.tableName = tableName;
        this.columnName = columnName;
        this.status = status;
    }

    public MonitorTable() {
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

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MonitorTable{" +
                "id=" + id +
                ", tableName='" + tableName + '\'' +
                ", columnName='" + columnName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
