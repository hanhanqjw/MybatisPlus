package com.lj.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lj.mybatisplus.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author luojie
 * @Description
 * @date 2022/3/6 09/55
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
    /**
     * 根据id查询用户信息为Map集合
     * @param id
     * @return
     */
    Map<String,Object> selectMapById(Long id);
}
