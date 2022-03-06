package com.lj.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lj.mybatisplus.mapper.UserMapper;
import com.lj.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author luojie
 * @Description
 * @date 2022/3/6 16/04
 */
@SpringBootTest
public class MybatisPlusWrapper {

    @Autowired
    private UserMapper userMapper;
    @Test
    public void test1(){
        /**
         * 查询用户名包含a，年龄在20到30之间，并且邮箱不为null的用户信息
         * SELECT id,name,age,email,isdelete FROM t_user
         * WHERE isdelete=0 AND (name LIKE ? AND age BETWEEN ? AND ? AND email IS NOT NULL)
         */
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name","a")
                .between("age",20,30)
                .isNotNull("email");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }
    @Test
    public void test2(){
        /**
         * 按年龄降序查询用户，如果年龄相同则按id升序排
         * SELECT id,name,age,email,isdelete FROM t_user WHERE isdelete=0 ORDER BY age DESC,id ASC
         */

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("age").orderByAsc("id");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void test3(){
        /**
         * /删除email为空的用户
         * UPDATE t_user SET isdelete=1 WHERE isdelete=0 AND (email IS NULL)
         */

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("email");
        int delete = userMapper.delete(queryWrapper);
        System.out.println("受影响的行数:"+delete);
    }

    @Test
    public void test4(){
        /**
         * 将（年龄大于20并且用户名中包含有a）或邮箱为null的用户信息修改
         */
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("age",20)
                .like("name","a")
                .or()
                .isNull("email");

        User user = new User();
        user.setAge(18);
        user.setEmail("user@qq.com");
        int update = userMapper.update(user, queryWrapper);

        System.out.println("受影响的行数:"+update);
    }

    @Test
    public void test5(){
        //将用户名中包含有a并且（年龄大于20或邮箱为null）的用户信息修改
        //UPDATE t_user SET age=?, email=? WHERE isdelete=0 AND (name LIKE ? AND (age > ? OR email IS NULL))
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name","a")
                .and(i->i.gt("age",19).or().isNull("email"));
        User user = new User();
        user.setAge(55);
        user.setEmail("user@qq.com");
        int update = userMapper.update(user, queryWrapper);

        System.out.println("受影响的行数:"+update);
    }

    @Test
    public void test6(){

        /**
         * 子查询
         * 查询id小于等于3的用户信息
         * SELECT id,name,age,email,isdelete FROM t_user WHERE isdelete=0
         * AND (id IN (select id from t_user where id<=3))
         */
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.inSql("id","select id from t_user where id<=3");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);

    }

}
