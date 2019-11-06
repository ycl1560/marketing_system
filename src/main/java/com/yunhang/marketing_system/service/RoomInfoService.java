package com.yunhang.marketing_system.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yunhang.marketing_system.mapper.RoomInfoMapper;
/**
*@author 杨春路
*@data 2019/10/31 11:57
*/
@Service
public class RoomInfoService{

    @Resource
    private RoomInfoMapper roomInfoMapper;

}
