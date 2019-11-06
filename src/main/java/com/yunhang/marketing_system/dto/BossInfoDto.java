package com.yunhang.marketing_system.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author 杨春路
 * @data 2019/10/31 11:26
 */
@Data
public class BossInfoDto {
    /**
     * Boss编号
     */
    @Id
    @Column(name = "boss_id")
    @GeneratedValue(generator = "JDBC")
    private Integer bossId;

    /**
     * Boss姓名
     */
    @Column(name = "boss_name")
    private String bossName;

    /**
     * Boss年龄
     */
    @Column(name = "boss_age")
    private Integer bossAge;

    /**
     * Boss性别:1:男 2:女
     */
    @Column(name = "boss_sex")
    private Short bossSex;

    /**
     * Boss电话
     */
    @Column(name = "boss_phone")
    private String bossPhone;

    /**
     * Boss照片地址
     */
    @Column(name = "boss_avatar")
    private String bossAvatar;

    /**
     * boss对应用户编号
     */
    @Column(name = "boss_user_id")
    private Integer bossUserId;

    /**
     * Boss身份证号
     */
    @Column(name = "boss_idcard_number")
    private String bossIdcardNumber;

    /**
     * Boss家庭住址
     */
    @Column(name = "boss_address")
    private String bossAddress;
    /**
     * 销量
     */
    private Integer sales_Record_Count;
}
