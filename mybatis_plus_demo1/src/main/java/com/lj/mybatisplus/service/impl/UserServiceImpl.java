package com.lj.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lj.mybatisplus.pojo.User;
import com.lj.mybatisplus.mapper.UserMapper;
import com.lj.mybatisplus.service.Userservice;
import org.springframework.stereotype.Service;

/**
 * @author luojie
 * @Description
 * @date 2022/3/6 11/39
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements Userservice{

}
