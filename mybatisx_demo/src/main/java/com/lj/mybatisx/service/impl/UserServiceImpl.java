package com.lj.mybatisx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lj.mybatisx.bean.User;
import com.lj.mybatisx.service.UserService;
import com.lj.mybatisx.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author 86182
* @description 针对表【t_user】的数据库操作Service实现
* @createDate 2022-03-06 19:44:38
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




