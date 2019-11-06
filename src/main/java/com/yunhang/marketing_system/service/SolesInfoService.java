package com.yunhang.marketing_system.service;

import com.yunhang.marketing_system.dto.BusinessInfoAndUserInfoDto;
import com.yunhang.marketing_system.dto.BusinessInfoDto;
import com.yunhang.marketing_system.dto.SolesInfoAndUserInfoDto;
import com.yunhang.marketing_system.dto.SolesInfoDto;
import com.yunhang.marketing_system.entity.BusinessManagerInfo;
import com.yunhang.marketing_system.entity.SolesInfo;
import com.yunhang.marketing_system.entity.UserInfo;
import com.yunhang.marketing_system.entity.UserRole;
import com.yunhang.marketing_system.mapper.SaleRecordInfoMapper;
import com.yunhang.marketing_system.mapper.UserInfoMapper;
import com.yunhang.marketing_system.mapper.UserRoleMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yunhang.marketing_system.mapper.SolesInfoMapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 杨春路
 * @data 2019/10/29 17:29
 */
@Service
public class SolesInfoService {

    @Resource
    private SolesInfoMapper solesInfoMapper;

    @Resource
    private UserInfoMapper userInfoMapper;

    @Resource
    private UserRoleMapper userRoleMapper;

    @Resource
    private SaleRecordInfoMapper saleRecordInfoMapper;

    /**
     * 添加销售员信息
     *
     * @param solesInfoAndUserInfoDto
     * @return
     */
    public int insertSolesInfo(SolesInfoAndUserInfoDto solesInfoAndUserInfoDto) {
        UserInfo userInfo = new UserInfo();
        SolesInfo solesInfo = new SolesInfo();
        UserRole userRole = new UserRole();
        //将接收的userInfo信息传入
        userInfo.setUserName(solesInfoAndUserInfoDto.getUserName());
        userInfo.setUserPassword(solesInfoAndUserInfoDto.getUserPassword());
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
        solesInfo.setSolesName(solesInfoAndUserInfoDto.getSolesName());
        solesInfo.setSolesAge(solesInfoAndUserInfoDto.getSolesAge());
        solesInfo.setSolesImgUrl(solesInfoAndUserInfoDto.getSolesImgUrl());
        solesInfo.setSolesPhone(solesInfoAndUserInfoDto.getSolesPhone());
        solesInfo.setSolesSex(solesInfoAndUserInfoDto.getSolesSex());
        int userId = userInfoMapper.selectUserByUserName(userInfo.getUserName()).getUserId();
        solesInfo.setSolesUserId(userId);
        //插入商务经理信息
        mark += solesInfoMapper.insertSelective(solesInfo);
        userRole.setUserId(userId);
        userRole.setRoleId(4);
        //执行角色插入
        mark += userRoleMapper.insertSelective(userRole);
        return mark;

    }

    /**
     * 更新销售员信息
     *
     * @param solesInfo
     * @return
     */
    public int updateSolesInfoById(SolesInfo solesInfo) {

        return solesInfoMapper.updateByPrimaryKeySelective(solesInfo);
    }

    /**
     * 删除销售员信息
     *
     * @param solesId
     * @return
     */
    public int deleteSolesInfoById(Integer solesId) {
        int mark = userInfoMapper.deleteByPrimaryKey(solesInfoMapper.selectByPrimaryKey(solesId).getSolesUserId());
        List<UserRole> userRoles = userRoleMapper.selectUserRoleByUserId(solesInfoMapper.selectByPrimaryKey(solesId).getSolesUserId());
        for (UserRole userRole : userRoles) {
            mark += userRoleMapper.deleteByPrimaryKey(userRole.getUserRoleId());
        }
        mark += solesInfoMapper.deleteByPrimaryKey(solesId);
        return mark;
    }

    /**
     * 查询所有销售员
     *
     * @return
     */
    public List<SolesInfoDto> queryAllSolesInfo() {
        List<SolesInfoDto> solesInfoDtos = new LinkedList();
        List<SolesInfo> solesInfos = solesInfoMapper.selectAll();
        int count = 0;
        for (SolesInfo solesInfo : solesInfos) {
            count = saleRecordInfoMapper.selectUserSaleRecordCountByUserId(solesInfo.getSolesUserId());
            SolesInfoDto solesInfoDto = new SolesInfoDto();
            BeanUtils.copyProperties(solesInfo, solesInfoDto);
            solesInfoDto.setSales_Record_Count(count);
            solesInfoDtos.add(solesInfoDto);
        }
        return solesInfoDtos;

    }

    /**
     * 查询单个销售员
     *
     * @param solesId
     * @return
     */
    public SolesInfoDto querySoleInfoById(int solesId) {
        SolesInfo solesInfo = solesInfoMapper.selectByPrimaryKey(solesId);
        SolesInfoDto solesInfoDto = new SolesInfoDto();
        int saleRecordCount = saleRecordInfoMapper.selectUserSaleRecordCountByUserId(solesInfo.getSolesUserId());
        BeanUtils.copyProperties(solesInfo, solesInfoDto);
        solesInfoDto.setSales_Record_Count(saleRecordCount);
        return solesInfoDto;
    }


}



