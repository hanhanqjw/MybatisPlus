package com.lj.mybatisx.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.lj.mybatisx.bean.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author 86182
* @description 针对表【t_user】的数据库操作Mapper
* @createDate 2022-03-06 19:44:38
* @Entity com.lj.mybatisx.bean.User
*/
public interface UserMapper extends BaseMapper<User> {

    int insertSelective(User user);

    int deleteByIdAndName(@Param("id") Long id, @Param("name") String name);

    int updateAgeAndName(@Param("age") Integer age, @Param("name") String name);

    List<User> selectAgeByAgeBetween(@Param("beginAge") Integer beginAge, @Param("endAge") Integer endAge);

    List<User> selectAllOrderByAgeDesc();

    List<User> selectNameOrderByAge();
}




