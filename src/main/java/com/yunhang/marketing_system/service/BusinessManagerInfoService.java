package com.yunhang.marketing_system.service;

import com.yunhang.marketing_system.dto.BossInfoAndUserInfoDto;
import com.yunhang.marketing_system.dto.BossInfoDto;
import com.yunhang.marketing_system.dto.BusinessInfoAndUserInfoDto;
import com.yunhang.marketing_system.dto.BusinessInfoDto;
import com.yunhang.marketing_system.entity.BossInfo;
import com.yunhang.marketing_system.entity.BusinessManagerInfo;
import com.yunhang.marketing_system.entity.UserInfo;
import com.yunhang.marketing_system.entity.UserRole;
import com.yunhang.marketing_system.mapper.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 杨春路
 * @data 2019/10/29 17:29
 */
@Service
public class BusinessManagerInfoService {

    @Resource
    private BusinessManagerInfoMapper businessManagerInfoMapper;

    @Resource
    private UserInfoMapper userInfoMapper;

    @Resource
    private UserRoleMapper userRoleMapper;

    @Resource
    private SaleRecordInfoMapper saleRecordInfoMapper;

    /**
     * 查询所有商务经理
     * @return
     */
    public List<BusinessInfoDto> queryAllBusinessManagerInfo() {
        List<BusinessInfoDto> businessInfoDtos=new LinkedList();
        List<BusinessManagerInfo> businessManagerInfos=businessManagerInfoMapper.selectAll();
        int count=0;
        for (BusinessManagerInfo businessManagerInfo : businessManagerInfos) {
            count=saleRecordInfoMapper.selectUserSaleRecordCountByUserId(businessManagerInfo.getBusinessUserId());
            BusinessInfoDto businessInfoDto=new BusinessInfoDto();
            BeanUtils.copyProperties(businessManagerInfo,businessInfoDto);
            businessInfoDto.setSales_Record_Count(count);
            businessInfoDtos.add(businessInfoDto);

        }
        return businessInfoDtos;
    }

    /**
     * 查询单个商务经理
     * @param businessId
     * @return
     */
    public BusinessInfoDto queryBusinessInfoById(Integer businessId) {
        BusinessManagerInfo businessManagerInfo=businessManagerInfoMapper.selectByPrimaryKey(businessId);
        BusinessInfoDto businessInfoDto=new BusinessInfoDto();
        int saleRecordCount=saleRecordInfoMapper.selectUserSaleRecordCountByUserId(businessManagerInfo.getBusinessUserId());
        BeanUtils.copyProperties(businessManagerInfo,businessInfoDto);
        businessInfoDto.setSales_Record_Count(saleRecordCount);
        return businessInfoDto;

    }

    /**
     * 添加商务经理
     * @param businessInfoAndUserInfoDto
     * @return
     */
    public int insertBusinessManagerInfo(BusinessInfoAndUserInfoDto businessInfoAndUserInfoDto) {
        UserInfo userInfo = new UserInfo();
        BusinessManagerInfo businessManagerInfo=new BusinessManagerInfo();
        UserRole userRole = new UserRole();
        //将接收的userInfo信息传入
        userInfo.setUserName(businessInfoAndUserInfoDto.getUserName());
        userInfo.setUserPassword(businessInfoAndUserInfoDto.getUserPassword());
        userInfo.setUserState((short) 4);
        userInfo.setUserCreatetime(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()));
        //判断用户是否已存在
        List<UserInfo> userInfos = userInfoMapper.selectAll();
        for (UserInfo info : userInfos) {
            if (info.getUserName().equals(userInfo.getUserName()))
                return 0;
        }
        //执行用户插入
        int mark = userInfoMapper.insertSelective(userInfo);
        businessManagerInfo.setBusinessAddress(businessInfoAndUserInfoDto.getBusinessAddress());
        businessManagerInfo.setBusinessAvatar(businessInfoAndUserInfoDto.getBusinessAvatar());
        businessManagerInfo.setBusinessIdcardNumber(businessInfoAndUserInfoDto.getBusinessIdcardNumber());
        businessManagerInfo.setBusinessManagerAge(businessInfoAndUserInfoDto.getBusinessManagerAge());
        businessManagerInfo.setBusinessManagerName(businessInfoAndUserInfoDto.getBusinessManagerName());
        businessManagerInfo.setBusinessManagerSex(businessInfoAndUserInfoDto.getBusinessManagerSex());
        businessManagerInfo.setBusinessManagerPhone(businessInfoAndUserInfoDto.getBusinessManagerPhone());
        int userId = userInfoMapper.selectUserByUserName(userInfo.getUserName()).getUserId();
        businessManagerInfo.setBusinessUserId(userId);
        //插入商务经理信息
        mark+=businessManagerInfoMapper.insertSelective(businessManagerInfo);
        userRole.setUserId(userId);
        userRole.setRoleId(3);
        //执行角色插入
        mark += userRoleMapper.insertSelective(userRole);
        return mark;
    }

    /**
     * 更新商务经理信息
     * @param businessManagerInfo
     * @return
     */
    public int updateBusinessInfo(BusinessManagerInfo businessManagerInfo) {
        return businessManagerInfoMapper.updateByPrimaryKeySelective(businessManagerInfo);
    }

    /**
     * 删除商务经理信息
     * @param businessManagerId
     * @return
     */
    public int deleteBusinessInfoById(Integer businessManagerId) {
        int mark=userInfoMapper.deleteByPrimaryKey(businessManagerInfoMapper.selectByPrimaryKey(businessManagerId).getBusinessUserId());
        List<UserRole> userRoles=userRoleMapper.selectUserRoleByUserId(businessManagerInfoMapper.selectByPrimaryKey(businessManagerId).getBusinessUserId());
        for (UserRole userRole : userRoles) {
            mark += userRoleMapper.deleteByPrimaryKey(userRole.getUserRoleId());
        }
        mark+=businessManagerInfoMapper.deleteByPrimaryKey(businessManagerId);
        return mark;
    }

}



