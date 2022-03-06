package com.lj.mybatisplus;

import com.lj.mybatisplus.pojo.User;
import com.lj.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class MybatisPlusDemo1ApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Test
    void contextLoads() {
    }

    @Test
    public void testSelectList(){
        userMapper.selectList(null).forEach(System.out ::println);
    }

    @Test
    public void testinsert(){


        User user = new User();
        user.setName("张三");
        user.setAge(18);
        user.setEmail("zhangsan@qq.com");
        int insert = userMapper.insert(user);
        System.out.println("result:"+insert);

        //id:1500301985021222913
        //这是因为MyBatis-Plus在实现插入数据时，会默认基于雪花算法的策略生成id
        System.out.println("id:"+user.getId());
    }
    @Test
    public void testDeleteById(){

        //通过id删除用户信息
        //DELETE FROM user WHERE id=?
        int i = userMapper.deleteById("1500301985021222913");
        System.out.println("受影响的行数："+i);
    }

    @Test
    public void testDeleteBatchIds(){
        //通过id批量删除记录
        //DELETE FROM user WHERE id IN ( ? , ? , ? )
        List<Long> idList = Arrays.asList(1l, 2l, 3l);
        int i = userMapper.deleteBatchIds(idList);
        System.out.println("受影响的行数："+i);
    }

    @Test
    public void testDeleteByMap(){
        /**
         * 根据map集合中所设置的条件删除记录
         * DELETE FROM user WHERE name = ? AND age = ?
         */
        Map<String, Object> map = new HashMap<>();
        map.put("age",18);
        map.put("name","张三");
        int i = userMapper.deleteByMap(map);

        System.out.println("受影响的行数："+i);
    }

    @Test
    public void testUpdateById(){
        /**
         * 通过Id修改数据
         * UPDATE user SET name=?, age=?, email=? WHERE id=?
         */

        User user = new User(4L,"admin",90,"admin@qq.com",0);
        int i = userMapper.updateById(user);
        System.out.println("受影响的行数："+i);
    }

    @Test
    public void testSelectById(){
        /**
         * 根据id查询用户信息
         * SELECT id,name,age,email FROM user WHERE id=?
         */
        User user = userMapper.selectById(4L);
        System.out.println("User:"+user);
    }

    @Test
    public void testSelectBatchIds(){

        /**
         * 根据多个id查询多个用户信息
         * SELECT id,name,age,email FROM user WHERE id IN ( ? , ? )
         */
        List<Long> idlist = Arrays.asList(4l, 5l);

        List<User> users = userMapper.selectBatchIds(idlist);
        users.forEach(System.out::println);
    }
    @Test
    public void testSelectByMap(){
        /**
         *通过map条件查询用户信息
         * SELECT id,name,age,email FROM user WHERE name = ? AND age = ?
         */
        Map<String, Object> map = new HashMap<>();
        map.put("age",24);
        map.put("name","admin");
        List<User> users = userMapper.selectByMap(map);

        users.forEach(System.out::println);
    }

    @Test
    public void testexists(){
        /**
         * SELECT COUNT( * ) FROM user
         */
        boolean exists = userMapper.exists(null);
        System.out.println(exists);
    }

    @Test
    public void testSelectMapById(){
        Map<String, Object> stringObjectMap = userMapper.selectMapById(4L);
        System.out.println(stringObjectMap);
    }





}
