package com.yunhang.marketing_system.entity;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;

/**
*@author 杨春路
*@data 2019/10/29 17:54
*/
@Data
@Table(name = "user_info")
public class UserInfo {
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
     * 用户密码
     */
    @Column(name = "user_password")
    private String userPassword;

    /**
     * 用户状态(4可用，8禁用)
     */
    @Column(name = "user_state")
    private Short userState;

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

}