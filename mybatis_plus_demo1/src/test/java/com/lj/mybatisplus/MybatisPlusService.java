package com.lj.mybatisplus;

import com.lj.mybatisplus.pojo.User;
import com.lj.mybatisplus.service.Userservice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luojie
 * @Description
 * @date 2022/3/6 14/56
 */
@SpringBootTest
public class MybatisPlusService {

    @Autowired
    private Userservice userService;
    @Test
    public void test(){
        long count = userService.count();
        System.out.println("总记录数："+count);
    }
    @Test
    public void testsaveUser(){
        /**
         * INSERT INTO user ( id, name, age, email ) VALUES ( ?, ?, ?, ? )
         */
        List<User> userlist = new ArrayList<>();
        userlist.add(new User(1L,"环境",23,"hj@qq.com",null));
        userlist.add(new User(2L,"成阿红",22,"ds@qq.com",null));
        userlist.add(new User(3L,"赵丽",56,"wed@qq.com",null));
        boolean b = userService.saveBatch(userlist);
        System.out.println(b);
    }

}
