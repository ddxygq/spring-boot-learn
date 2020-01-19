package com.ikeguang.ajax.dao;



import com.ikeguang.ajax.model.ExecutionJobs;

import java.util.List;
import java.util.Map;

/**
 * @Author: keguang
 * @Date: 2019/12/24 14:56
 * @version: v1.0.0
 * @description:
 */
public interface ExecutionJobsMapper {

    /**
     * 返回失败的azkaban任务
     * @param param
     * @return
     */
    List<ExecutionJobs> getFailedList(Map<String, Object> param);
}
