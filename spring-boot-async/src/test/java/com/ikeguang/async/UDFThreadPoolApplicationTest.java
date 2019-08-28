package com.ikeguang.async;

import com.ikeguang.async.async.Task2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ Author: keguang
 * @ Date: 2019/8/28 17:49
 * @ version: v1.0.0
 * @ description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UDFThreadPoolApplicationTest {

    @Autowired
    private Task2 task2;

    @Test
    public void test() throws InterruptedException {
        task2.doTaskOne();
        task2.doTaskTwo();
        task2.doTaskThree();

        Thread.currentThread().join();
    }
}
