package com.yunhang.marketing_system.entity;

import javax.persistence.*;
import lombok.Data;

/**
*@author 杨春路
*@data 2019/10/29 17:29
*/
@Data
@Table(name = "building_img")
public class BuildingImg {
    /**
     * 楼盘图片编号
     */
    @Id
    @Column(name = "building_img_id")
    private Integer buildingImgId;

    /**
     * 楼盘图片名称
     */
    @Column(name = "building_img_name")
    private String buildingImgName;

    /**
     * 图片地址
     */
    @Column(name = "build_img_url")
    private String buildImgUrl;

    /**
     * 楼盘编号
     */
    @Column(name = "building_id")
    private Integer buildingId;
}