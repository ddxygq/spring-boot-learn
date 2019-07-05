package com.ikeguang.scheduler.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @ Author: keguang
 * @ Date: 2019/7/5 17:51
 * @ version: v1.0.0
 * @ description:
 */
@Component
public class SchedulerTask {

    private int count = 0;

    @Scheduled(cron = "*/5 * * * * ?")
    private void process(){
        System.out.println("this is scheduler task " + (count++));
    }

}
