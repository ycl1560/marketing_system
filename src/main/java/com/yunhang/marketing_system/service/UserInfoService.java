package com.yunhang.marketing_system.service;

import com.yunhang.marketing_system.dto.UserInfoDto;
import com.yunhang.marketing_system.entity.BossInfo;
import com.yunhang.marketing_system.entity.UserInfo;
import com.yunhang.marketing_system.entity.UserRole;
import com.yunhang.marketing_system.mapper.CustomerInfoMapper;
import com.yunhang.marketing_system.mapper.SaleRecordInfoMapper;
import com.yunhang.marketing_system.mapper.UserRoleMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yunhang.marketing_system.mapper.UserInfoMapper;

import java.util.List;

/**
*@author 杨春路
*@data 2019/10/29 17:54
*/
@Service
public class UserInfoService{

    @Resource
    private UserInfoMapper userInfoMapper;

    @Resource
    private SaleRecordInfoMapper saleRecordInfoMapper;

    @Resource
    private CustomerInfoMapper customerInfoMapper;
    @Resource
    private UserRoleMapper userRoleMapper;
   /* public String selectPasswordByUserName(String userName) {
        List<UserInfo> userInfos=userInfoMapper.selectAll();
        for (UserInfo userInfo : userInfos) {
            if(userInfo.getUserName().equals(userName))
                return userInfo.getUserPassword();
        }
        return null;
    }*/

    public UserInfo selectUserByUserName(String userName) {
        return userInfoMapper.selectUserByUserName(userName);
    }

    public UserInfo selectUserById(Integer userId) {

       return userInfoMapper.selectByPrimaryKey(userId);
    }

    /**
     * 修改管理员密码
     * @param userName
     * @param userPassword
     * @return
     */
    public int updateAdminPasswordByUserName(String userName,String userPassword) {
       UserInfo userInfo= userInfoMapper.selectUserByUserName(userName);
       userInfo.setUserPassword(userPassword);
       return userInfoMapper.updateByPrimaryKey(userInfo);
    }



    /**
     * 登陆时查询用户信息
     * @param userName
     * @return
     */
    public UserInfoDto selectUserByUserNameDto(String userName) {
        UserInfoDto userInfoDto=new UserInfoDto();
       UserInfo userInfo= userInfoMapper.selectUserByUserName(userName);
        BeanUtils.copyProperties(userInfo,userInfoDto);
        List<UserRole> userRoles=userRoleMapper.selectUserRoleByUserId(userInfo.getUserId());
        for (UserRole userRole : userRoles) {
            userInfoDto.setUserRole(userRole.getRoleId() );
        }

        return userInfoDto;
    }

    /**
     * APP个人中心用户信息查询
     * @param userId
     * @return
     */
    public UserInfoDto appSelectUserInfoById(int userId) {
       UserInfo userInfo=userInfoMapper.selectByPrimaryKey(userId);
       UserInfoDto userInfoDto=new UserInfoDto();
       BeanUtils.copyProperties(userInfo,userInfoDto);
       //查询销售量
       int saleRecordCount  = saleRecordInfoMapper.selectUserSaleRecordCountByUserId(userId);
       //查询客户数
       userInfoDto.setUserSalesCount(saleRecordCount);
       int customerCount=customerInfoMapper.selectCountByUserId(userId);
       userInfoDto.setUserCustomerCount(customerCount);
       List<UserRole> userRoles=userRoleMapper.selectUserRoleByUserId(userId);
       for (UserRole userRole : userRoles) {
           userInfoDto.setUserRole(userRole.getRoleId());
       }
       return userInfoDto;
    }
}
