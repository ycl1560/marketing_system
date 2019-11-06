package com.yunhang.marketing_system.entity;

import javax.persistence.*;
import lombok.Data;

/**
*@author 杨春路
*@data 2019/10/30 12:16
*/
@Data
@Table(name = "role_permissions")
public class RolePermissions {
    /**
     * 角色权限编号
     */
    @Id
    @Column(name = "role_permissions_id")
    private Integer rolePermissionsId;

    /**
     * 角色编号
     */
    @Column(name = "role_id")
    private Integer roleId;

    /**
     * 权限编号
     */
    @Column(name = "permissions_id")
    private Integer permissionsId;
}