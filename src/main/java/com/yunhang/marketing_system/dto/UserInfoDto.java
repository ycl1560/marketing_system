package com.yunhang.marketing_system.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author 杨春路
 * @data 2019/10/31 12:07
 */
@Data
public class UserInfoDto {
    /**
     * 用户编号
     */
    @Id
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;




    /**
     * 用户注册时间
     */
    @Column(name = "user_createtime")
    private String userCreatetime;

    /**
     * 用户登陆时间
     */
    @Column(name = "user_logintime")
    private String userLogintime;

    /**
     * 用户销量
     */
    private Integer userSalesCount;

    /**
     * 用户客户数量
     */

    private Integer userCustomerCount;

    /**
     * 用户角色
     */

    private int userRole;
}
