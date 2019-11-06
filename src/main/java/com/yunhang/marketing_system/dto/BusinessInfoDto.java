package com.yunhang.marketing_system.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author 杨春路
 * @data 2019/10/31 15:24
 */
@Data
public class BusinessInfoDto {
    /**
     * 商务经理编号
     */
    @Id
    @Column(name = "business_manager_id")
    @GeneratedValue(generator = "JDBC")
    private Integer businessManagerId;

    /**
     * 商务经理姓名
     */
    @Column(name = "business_manager_name")
    private String businessManagerName;

    /**
     * 商务经理年龄
     */
    @Column(name = "business_manager_age")
    private Integer businessManagerAge;

    /**
     * 商务经理性别(1男，2女)
     */
    @Column(name = "business_manager_sex")
    private Short businessManagerSex;

    /**
     * 商务经理电话
     */
    @Column(name = "business_manager_phone")
    private String businessManagerPhone;

    /**
     * 商户经理照片地址
     */
    @Column(name = "business_avatar")
    private String businessAvatar;

    /**
     * 商户经理身份证号
     */
    @Column(name = "Business_idcard_number")
    private String businessIdcardNumber;

    /**
     * 商户经理家庭住址
     */
    @Column(name = "Business_address")
    private String businessAddress;

    /**
     * 商户经理对应用户编号
     */
    @Column(name = "Business_user_id")
    private Integer businessUserId;

    /**
     * 商务经理对应上级用户编号
     */
    @Column(name = "superior_user_id")
    private Integer superiorUserId;



    /**
     * 销量
     */
    private Integer sales_Record_Count;
}
