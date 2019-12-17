package com.ikeguang.jpa.repository;

import com.ikeguang.jpa.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

/**
 * @ Author: keguang
 * @ Date: 2019/7/5 14:26
 * @ version: v1.0.0
 * @ description:
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Resource
    private UserRepository userRepository;

    @Test
    public void testSave(){
        Date date = new Date();
        // DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = simpleDateFormat.format(date);

        System.out.println(formattedDate);

        userRepository.save(new User("aa", "aa@126.com","aa", "aa123456",  formattedDate));
        userRepository.save(new User("bb", "bb@126.com","bb", "bb123456",  formattedDate));
        userRepository.save(new User("cc", "cc@126.com","cc", "cc123456",  formattedDate));

    }

    @Test
    public void testBaseQuery(){

        Optional<User> optionalUser = userRepository.findById(5L);
        System.out.println(optionalUser.orElse(new User()));

        User user = userRepository.findByUserName("dd");
        System.out.println(user);

        User user2 = userRepository.findByEmail("bb@126.com");
        System.out.println(user2);

    }

    @Test
    public void testDeleteById(){
        userRepository.deleteById(4L);
        User user = userRepository.findByUserName("dd");
        System.out.println(user);
    }
}
