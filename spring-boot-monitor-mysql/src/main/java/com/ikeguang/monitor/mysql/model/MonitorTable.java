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

    public long getId() {
        return id;
    }

    public String getTableName() {
        return tableName;
    }

    public String getColumnName() {
        return columnName;
    }

    public String getStatus() {
        return status;
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
