package com.yunhang.marketing_system.mapper;

import com.yunhang.marketing_system.entity.UserRole;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
*@author 杨春路
*@data 2019/10/30 12:17
*/
@org.apache.ibatis.annotations.Mapper
public interface UserRoleMapper extends Mapper<UserRole> {
    List<UserRole> selectUserRoleByUserId(Integer userId);
}