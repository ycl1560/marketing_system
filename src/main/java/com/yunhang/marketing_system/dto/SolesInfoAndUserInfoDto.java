package com.yunhang.marketing_system.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author 杨春路
 * @data 2019/10/31 16:51
 */
@Data
public class SolesInfoAndUserInfoDto {
    /**
     * 销售员工编号
     */
    @Id
    @Column(name = "soles_id")
    @GeneratedValue(generator = "JDBC")
    private Integer solesId;

    /**
     * 销售员工姓名
     */
    @Column(name = "soles_name")
    private String solesName;

    /**
     * 销售员工年龄
     */
    @Column(name = "soles_age")
    private Integer solesAge;

    /**
     * 销售员工性别(1男，2女)
     */
    @Column(name = "soles_sex")
    private Short solesSex;

    /**
     * 销售员工电话
     */
    @Column(name = "soles_phone")
    private String solesPhone;

    /**
     * 销售员工照片地址
     */
    @Column(name = "soles_img_url")
    private String solesImgUrl;


    /**
     * 销售员身份证号
     */
    @Column(name = "soles_idcard_number")
    private String solesIdcardNumber;

    /**
     * 销售员家庭住址
     */
    @Column(name = "soles_address")
    private String solesAddress;

    /**
     * 销售员对应上级编号
     */
    @Column(name = "superior_user_id")
    private Integer superiorUserId;

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
     * 用户注册时间
     */
    @Column(name = "user_createtime")
    private String userCreatetime;



}
