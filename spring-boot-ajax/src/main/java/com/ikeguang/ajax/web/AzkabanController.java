package com.ikeguang.ajax.web;

import com.ikeguang.ajax.dao.ExecutionJobsMapper;
import com.ikeguang.ajax.model.ExecutionJobs;
import com.ikeguang.ajax.model.SelectDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

/**
 * @Author: keguang
 * @Date: 2019/12/13 14:38
 * @version: v1.0.0
 * @description:
 */
@Controller
public class AzkabanController {

    private static final Logger logger = LoggerFactory.getLogger(AzkabanController.class);

    @Resource
    ExecutionJobsMapper executionJobsMapper;

    @RequestMapping(value = "/selectDate", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public List<ExecutionJobs> failedDate(@RequestBody SelectDate selectDate,
                                          @RequestParam(value = "pageNum", defaultValue = "0") int pageNum,
                                          @RequestParam(value = "pageSize", defaultValue = "100") int pageSize) {

        System.out.println(selectDate.toString());

        Map<String, Object> param = new HashMap<>(8);

        if(selectDate.getBeginDate() == null && selectDate.getEndDate() == null){
            long nowTime = System.currentTimeMillis();
            long timestamp = nowTime - ((nowTime + TimeZone.getDefault().getRawOffset()) % (24 * 60 * 60 * 1000L));

            param.put("beginday", timestamp);
            param.put("endDay", timestamp + 24 * 60 * 60 * 1000L);

            List<ExecutionJobs> azkabanExecutionJobs = executionJobsMapper.getFailedList(param);

            return azkabanExecutionJobs;
        }

        long beginday = Integer.MIN_VALUE;
        long endDay = Long.MAX_VALUE;

        // begin的零点时间戳
        if (selectDate.getBeginDate() != null) {
            long begin = selectDate.getBeginDate().getTime();
            beginday = begin - ((begin + TimeZone.getDefault().getRawOffset()) % (24 * 60 * 60 * 1000L));
        }

        // end的后一天的零点时间戳
        if (selectDate.getEndDate() != null) {
            long end = selectDate.getEndDate().getTime();
            endDay = end - ((end + TimeZone.getDefault().getRawOffset()) % (24 * 60 * 60 * 1000L)) + 24 * 60 * 60 * 1000L;
        }

        logger.info("beginday -> " + beginday + ", endDay ->" + endDay);

        param.put("beginday", beginday);
        param.put("endDay", endDay);

        List<ExecutionJobs> azkabanExecutionJobs = executionJobsMapper.getFailedList(param);
        // model.addAttribute("azkabanExecutionJobs", azkabanExecutionJobs);
        logger.info("azkabanExecutionJobs.size() -> {}", new Object[]{azkabanExecutionJobs.size()});

        // return "azkaban/failed::data";
        return azkabanExecutionJobs;
    }

    @RequestMapping("/")
    public String failed(Model model,
                         @RequestParam(value = "pageNum", defaultValue = "0") int pageNum,
                         @RequestParam(value = "pageSize", defaultValue = "100") int pageSize) {

        Map<String, Object> param = new HashMap<>(8);

        long nowTime = System.currentTimeMillis();
        long timestamp = nowTime - ((nowTime + TimeZone.getDefault().getRawOffset()) % (24 * 60 * 60 * 1000L));

        param.put("beginday", timestamp);
        param.put("endDay", timestamp + 24 * 60 * 60 * 1000L);

        List<ExecutionJobs> azkabanExecutionJobs = executionJobsMapper.getFailedList(param);
        model.addAttribute("azkabanExecutionJobs", azkabanExecutionJobs);
        logger.info("azkabanExecutionJobs.size() -> {}", new Object[]{azkabanExecutionJobs.size()});

        return "azkaban/failed";

    }

}
