package com.yunhang.marketing_system.service;

import com.yunhang.marketing_system.entity.RolePermissions;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yunhang.marketing_system.mapper.RolePermissionsMapper;

import java.util.LinkedList;
import java.util.List;

/**
*@author 杨春路
*@data 2019/10/30 12:16
*/
@Service
public class RolePermissionsService{

    @Resource
    private RolePermissionsMapper rolePermissionsMapper;

    public List<RolePermissions> selectRolePermissionByRoleId(Integer roleId) {
        List<RolePermissions> rolePermission=rolePermissionsMapper.selectAll();
        List<RolePermissions> rolePermissions= new LinkedList();
        for (RolePermissions permissions : rolePermission) {
            if(permissions.getRoleId()==roleId)
                rolePermissions.add(permissions);
        }
        return rolePermissions;
    }
}
