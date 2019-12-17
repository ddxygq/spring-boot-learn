package com.ikeguang.datasourcejpa;

import com.ikeguang.datasourcejpa.model.p.PrimaryEntity;
import com.ikeguang.datasourcejpa.model.p.PrimaryRepository;
import com.ikeguang.datasourcejpa.model.s.SecondaryEntity;
import com.ikeguang.datasourcejpa.model.s.SecondaryRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ Author: keguang
 * @ Date: 2019/12/17 17:03
 * @ version: v1.0.0
 * @ description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private PrimaryRepository primaryRepository;

    @Autowired
    SecondaryRepository secondaryRepository;

    @Test
    public void test(){
        primaryRepository.save(new PrimaryEntity(1, "ikeguang.com"));
        primaryRepository.save(new PrimaryEntity(2, "kg"));
        primaryRepository.save(new PrimaryEntity(3, "keguang"));

        Assert.assertEquals(3, primaryRepository.findAll().size());

        secondaryRepository.save(new SecondaryEntity(1,"keguang"));
        secondaryRepository.save(new SecondaryEntity(2,"keguang2"));
        secondaryRepository.save(new SecondaryEntity(3,"keguang3"));

        Assert.assertEquals(3, secondaryRepository.findAll().size());

    }

}
