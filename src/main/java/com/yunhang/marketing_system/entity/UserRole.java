package com.yunhang.marketing_system.entity;

import javax.persistence.*;
import lombok.Data;

/**
*@author 杨春路
*@data 2019/10/30 12:17
*/
@Data
@Table(name = "user_role")
public class UserRole {
    /**
     * 用户角色表编号
     */
    @Id
    @Column(name = "user_role_id")
    private Integer userRoleId;

    /**
     * 用户编号
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 角色编号
     */
    @Column(name = "role_id")
    private Integer roleId;
}