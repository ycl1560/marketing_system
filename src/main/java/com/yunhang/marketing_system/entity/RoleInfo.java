package com.yunhang.marketing_system.entity;

import javax.persistence.*;
import lombok.Data;

/**
*@author 杨春路
*@data 2019/10/30 12:28
*/
@Data
@Table(name = "role_info")
public class RoleInfo {
    /**
     * 角色编号
     */
    @Id
    @Column(name = "role_id")
    private Integer roleId;

    /**
     * 角色类型
     */
    @Column(name = "role_type")
    private String roleType;

    /**
     * 角色描述
     */
    @Column(name = "role_description")
    private String roleDescription;
}