package com.lj.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lj.mybatisplus.mapper.UserMapper;
import com.lj.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author luojie
 * @Description
 * @date 2022/3/6 17/20
 */
@SpringBootTest
public class MybatisplusPage {

    @Autowired
    private UserMapper userMapper;
    @Test
    public void testPage(){
        Page<User> page = new Page<>(3, 2);

        userMapper.selectPage(page, null);
        List<User> list = page.getRecords();

        list.forEach(System.out::println);
        System.out.println("当前页：" + page.getCurrent());
        System.out.println("当前页的条数：" + page.getSize());
        System.out.println("总记录数：" + page.getTotal());
        System.out.println("总页数：" + page.getPages());
        System.out.println("是否有上一页：" + page.hasPrevious());
        System.out.println("是否有下一页：" + page.hasNext());


    }
}
