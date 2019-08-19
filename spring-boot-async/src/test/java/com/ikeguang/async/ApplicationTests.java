package com.ikeguang.async;

import com.ikeguang.async.async.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Future;

/**
 * @ Author: keguang
 * @ Date: 2019/8/19 16:03
 * @ version: v1.0.0
 * @ description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private Task task;

    @Test
    public void test() throws InterruptedException {
        long start = System.currentTimeMillis();

        Future<String> task1 = task.doTaskOne();
        Future<String> task2 = task.doTaskTwo();
        Future<String> task3 = task.doTaskThree();


        while (true){
            if(task1.isDone() && task2.isDone() && task3.isDone()){
                break;
            }

            // 一秒钟检查一次
            Thread.sleep(1000);
        }

        long end = System.currentTimeMillis();

        System.out.println("任务全部完成，耗时：" + (end - start) + "毫秒");
    }
}
