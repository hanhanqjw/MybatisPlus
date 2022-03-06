package com.lj.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author luojie
 * @Description
 * @date 2022/3/6 09/53
 */

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
//设置实体类所对应的表名 可以在application.yml里配置
//@TableName("user")
public class User {

    //将属性所对应的字段指定为主键
    //type IdType.ASSIGN_ID雪花算法 IdType.AUTO数据库自增
//    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;
    @TableLogic
    private Integer isdelete;

}
