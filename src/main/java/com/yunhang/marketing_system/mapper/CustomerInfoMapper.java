package com.yunhang.marketing_system.mapper;

import com.yunhang.marketing_system.entity.CustomerInfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author 杨春路
 * @data 2019/10/31 18:21
 */
@org.apache.ibatis.annotations.Mapper
public interface CustomerInfoMapper extends Mapper<CustomerInfo> {
    int selectCountByUserId(int userId);

    List<CustomerInfo> selectCustomerByUserId(int userId);
}