package com.yunhang.marketing_system.service;

import com.yunhang.marketing_system.entity.UserRole;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yunhang.marketing_system.mapper.UserRoleMapper;

import java.util.List;

/**
*@author 杨春路
*@data 2019/10/30 12:17
*/
@Service
public class UserRoleService{

    @Resource
    private UserRoleMapper userRoleMapper;

    public List<UserRole> selectUserRoleByUserId(Integer userId) {
        List<UserRole> userRoles=userRoleMapper.selectUserRoleByUserId(userId);

        return userRoles;
    }
}
