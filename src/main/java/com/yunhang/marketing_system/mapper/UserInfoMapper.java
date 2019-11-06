package com.yunhang.marketing_system.mapper;

import com.yunhang.marketing_system.entity.UserInfo;
import tk.mybatis.mapper.common.Mapper;

/**
*@author 杨春路
*@data 2019/10/29 17:54
*/
@org.apache.ibatis.annotations.Mapper
public interface UserInfoMapper extends Mapper<UserInfo> {


    UserInfo selectUserByUserName(String userName);
}