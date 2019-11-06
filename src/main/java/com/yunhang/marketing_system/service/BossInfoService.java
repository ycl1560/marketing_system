package com.yunhang.marketing_system.service;

import com.yunhang.marketing_system.dto.BossInfoAndUserInfoDto;
import com.yunhang.marketing_system.dto.BossInfoDto;
import com.yunhang.marketing_system.entity.BossInfo;
import com.yunhang.marketing_system.entity.UserInfo;
import com.yunhang.marketing_system.entity.UserRole;
import com.yunhang.marketing_system.mapper.SaleRecordInfoMapper;
import com.yunhang.marketing_system.mapper.UserInfoMapper;
import com.yunhang.marketing_system.mapper.UserRoleMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yunhang.marketing_system.mapper.BossInfoMapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 杨春路
 * @data 2019/10/29 17:23
 */
@Service
public class BossInfoService {

    @Resource
    private BossInfoMapper bossInfoMapper;

    @Resource
    private UserInfoMapper userInfoMapper;

    @Resource
    private UserRoleMapper userRoleMapper;

    @Resource
    private SaleRecordInfoMapper saleRecordInfoMapper;

    /**
     * Boss信息添加，与此同时会添加一个用户,并设置角色为Boss，自动获得相应的权限
     *
     * @param bossInfoAndUserInfoDto
     * @return
     */
    public int insertBossInfo(BossInfoAndUserInfoDto bossInfoAndUserInfoDto) {

        UserInfo userInfo = new UserInfo();
        BossInfo bossInfo = new BossInfo();
        UserRole userRole = new UserRole();
        //将接收的userInfo信息传入
        userInfo.setUserName(bossInfoAndUserInfoDto.getUserName());
        userInfo.setUserPassword(bossInfoAndUserInfoDto.getUserPassword());
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
        //将接收的bossInfo信息传入
        bossInfo.setBossSex(bossInfoAndUserInfoDto.getBossSex());
        bossInfo.setBossPhone(bossInfoAndUserInfoDto.getBossPhone());
        bossInfo.setBossName(bossInfoAndUserInfoDto.getBossName());
        bossInfo.setBossAvatar(bossInfoAndUserInfoDto.getBossAvatar());
        bossInfo.setBossAge(bossInfoAndUserInfoDto.getBossAge());
        int userId = userInfoMapper.selectUserByUserName(userInfo.getUserName()).getUserId();
        bossInfo.setBossUserId(userId);

        //执行Boss插入
        mark += bossInfoMapper.insertSelective(bossInfo);
        userRole.setUserId(userId);
        userRole.setRoleId(2);
        //执行角色插入
        mark += userRoleMapper.insertSelective(userRole);
        return mark;


    }

    /**
     * 删除Boss信息
     *
     * @param bossId
     * @return
     */

    public int deleteBossInfoById(int bossId) {
        int mark = userInfoMapper.deleteByPrimaryKey(bossInfoMapper.selectByPrimaryKey(bossId).getBossUserId());
        List<UserRole> userRole = userRoleMapper.selectUserRoleByUserId(bossInfoMapper.selectByPrimaryKey(bossId).getBossUserId());
        for (UserRole role : userRole) {
            mark += userRoleMapper.deleteByPrimaryKey(role.getUserRoleId());
        }
        mark += bossInfoMapper.deleteByPrimaryKey(bossId);
        return mark;
    }

    /**
     * 更新Boss信息
     *
     * @param bossInfo
     * @return
     */
    public int updateBossInfo(BossInfo bossInfo) {
        return bossInfoMapper.updateByPrimaryKeySelective(bossInfo);
    }

    /**
     * 查询所有Boss信息
     *
     * @return
     */
    public List<BossInfoDto> queryAllBossInfo() {
        List<BossInfoDto> bossInfoDtos = new LinkedList();
        List<BossInfo> bossInfos = bossInfoMapper.selectAll();
        int saleRecordCount = 0;
        for (BossInfo bossInfo : bossInfos) {
            saleRecordCount = saleRecordInfoMapper.selectUserSaleRecordCountByUserId(bossInfo.getBossUserId());
            BossInfoDto bossInfoDto = new BossInfoDto();
            BeanUtils.copyProperties(bossInfo, bossInfoDto);
            bossInfoDto.setSales_Record_Count(saleRecordCount);
            bossInfoDtos.add(bossInfoDto);
        }
        return bossInfoDtos;
    }

    /**
     * 查询单个Boss信息
     *
     * @param bossId
     * @return
     */
    public BossInfoDto queryBossInfoById(int bossId) {
        BossInfo bossInfo = bossInfoMapper.selectByPrimaryKey(bossId);
        BossInfoDto bossInfoDto = new BossInfoDto();
        int saleRecordCount  = saleRecordInfoMapper.selectUserSaleRecordCountByUserId(bossInfo.getBossUserId());
        BeanUtils.copyProperties(bossInfo, bossInfoDto);
        bossInfoDto.setSales_Record_Count(saleRecordCount);
        return bossInfoDto;
    }
}


