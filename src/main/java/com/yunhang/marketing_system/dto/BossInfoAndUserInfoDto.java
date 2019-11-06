package com.yunhang.marketing_system.dto;

import com.yunhang.marketing_system.entity.BossInfo;
import com.yunhang.marketing_system.entity.UserInfo;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author 杨春路
 * @data 2019/10/30 16:45
 */
@Data
public class BossInfoAndUserInfoDto {
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
