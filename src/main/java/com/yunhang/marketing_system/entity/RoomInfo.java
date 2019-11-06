package com.yunhang.marketing_system.entity;

import javax.persistence.*;
import lombok.Data;

/**
*@author 杨春路
*@data 2019/10/31 11:57
*/
@Data
@Table(name = "room_info")
public class RoomInfo {
    /**
     * 房屋信息表编号
     */
    @Column(name = "room_info_id")
    private Integer roomInfoId;

    /**
     * 房屋所在楼盘编号
     */
    @Column(name = "building_id")
    private Integer buildingId;

    /**
     * 房屋所在栋号码
     */
    @Column(name = "room_building_number")
    private Integer roomBuildingNumber;

    /**
     * 房屋单元号
     */
    @Column(name = "room_unit_number")
    private Integer roomUnitNumber;

    /**
     * 房屋房号
     */
    @Column(name = "room_number")
    private Integer roomNumber;
}