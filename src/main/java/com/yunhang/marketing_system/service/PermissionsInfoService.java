package com.yunhang.marketing_system.service;

import com.yunhang.marketing_system.entity.PermissionsInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yunhang.marketing_system.mapper.PermissionsInfoMapper;
/**
*@author 杨春路
*@data 2019/10/30 12:28
*/
@Service
public class PermissionsInfoService{

    @Resource
    private PermissionsInfoMapper permissionsInfoMapper;

    public String selectPermissionInfoByPermissionsId(Integer permissionsId) {
        PermissionsInfo permissionsInfo=permissionsInfoMapper.selectByPrimaryKey(permissionsId);
        return permissionsInfo.getPermissionsName();
    }
}
