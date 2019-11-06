package com.yunhang.marketing_system.entity;

import javax.persistence.*;
import lombok.Data;

/**
*@author 杨春路
*@data 2019/10/30 12:28
*/
@Data
@Table(name = "permissions_info")
public class PermissionsInfo {
    /**
     * 权限编号
     */
    @Id
    @Column(name = "permissions_id")
    private Integer permissionsId;

    /**
     * 权限名称
     */
    @Column(name = "permissions_name")
    private String permissionsName;
}