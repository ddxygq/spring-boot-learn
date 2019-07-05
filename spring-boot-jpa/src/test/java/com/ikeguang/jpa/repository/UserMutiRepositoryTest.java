package com.ikeguang.jpa.repository;

import com.ikeguang.jpa.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @ Author: keguang
 * @ Date: 2019/7/5 16:54
 * @ version: v1.0.0
 * @ description:
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMutiRepositoryTest {

    @Resource
    private UserMutiRepository userMutiRepository;

    @Test
    public void testPageQuery(){
        int page = 1, size = 2;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(page, size, sort);

        Page<User> pageUsers= userMutiRepository.findAll(pageable);
        System.out.println("totalElements => " + pageUsers.getTotalElements());
        System.out.println("totalPages => " + pageUsers.getTotalPages());
        for(User user : pageUsers){
            System.out.println(user);
        }

        Page<User> pageUsers2 = userMutiRepository.findByUserName("bb", pageable);
        for(User user : pageUsers2){
            System.out.println(user);
        }

    }
}
