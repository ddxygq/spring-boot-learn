package com.ikeguang.ajax.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Author: keguang
 * @Date: 2019/12/13 14:01
 * @version: v1.0.0
 * @description: azkaban 执行job实体
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class ExecutionJobs {

    @Id
    private long execId;
    private long projectId;
    private long version;
    private String flowId;
    private String jobId;
    private int attempt;
    private long startTime;
    private long endTime;

    @Column(name = "status", columnDefinition = "tinyint(4)")
    private byte status;

    @Column(name="input_params", columnDefinition="longblob", nullable=true)
    private byte[] inputParams;

    @Column(name="output_params", columnDefinition="longblob", nullable=true)
    private byte[] outputParams;

    @Column(name="attachments", columnDefinition="longblob", nullable=true)
    private byte[] attachments;

}
