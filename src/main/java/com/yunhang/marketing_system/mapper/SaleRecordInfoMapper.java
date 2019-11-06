package com.yunhang.marketing_system.mapper;

import com.yunhang.marketing_system.entity.SaleRecordInfo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
*@author 杨春路
*@data 2019/10/31 12:39
*/
@org.apache.ibatis.annotations.Mapper
public interface SaleRecordInfoMapper extends Mapper<SaleRecordInfo> {
    int selectUserSaleRecordCountByUserId(Integer bossUserId);
    List<SaleRecordInfo> selectSaleRecordByUserId(String userId);

    List<SaleRecordInfo> selectSaleRecordByUserIdAndDate(SaleRecordInfo saleRecordInfo);
}