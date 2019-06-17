package com.cnpc;

import com.cnpc.emtity.User;
import com.cnpc.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName test
 * @Description TODO
 * @Author magic_罗璋
 * @Date 2019/6/17 10:09
 * @Version 1.0
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
public class test {
    @Autowired
    UserRepository userRepository;
    @Test
    public void addUser(){
        User user = null;
        List<User> userList = new ArrayList<>(  );
        for (int i = 10; i < 100; i++) {
            user = new User( "magic"+i,"magiclz233"+i+"@163.com",
                    18+i,"19"+i+"-6-17" );
            userList.add( user );
        }
        userRepository.saveAll( userList );
    }

    @Test
    public void test(){
        int i = 19;
        String d = "20"+i+"-6-17";
        System.out.println(d.getClass());
    }
}
