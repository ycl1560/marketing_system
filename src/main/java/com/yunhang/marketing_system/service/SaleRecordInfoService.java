package com.yunhang.marketing_system.service;

import com.yunhang.marketing_system.entity.SaleRecordInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yunhang.marketing_system.mapper.SaleRecordInfoMapper;

import java.util.List;

/**
*@author 杨春路
*@data 2019/10/31 12:39
*/
@Service
public class SaleRecordInfoService{

    @Resource
    private SaleRecordInfoMapper saleRecordInfoMapper;

    public List<SaleRecordInfo> selectSaleRecordByUserId(String userId) {

        List<SaleRecordInfo> saleRecordInfos=saleRecordInfoMapper.selectSaleRecordByUserId(userId);
        return saleRecordInfos;
    }

    public List<SaleRecordInfo> selectSaleRecordByUserIdAndDate(SaleRecordInfo saleRecordInfo) {
        List<SaleRecordInfo> saleRecordInfos=saleRecordInfoMapper.selectSaleRecordByUserIdAndDate(saleRecordInfo);
        return saleRecordInfos;
    }
}
