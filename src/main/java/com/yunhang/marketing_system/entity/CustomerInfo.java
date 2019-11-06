package com.yunhang.marketing_system.entity;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;

/**
 * @author 杨春路
 * @data 2019/10/31 18:21
 */
@Data
@Table(name = "customer_info")
public class CustomerInfo {
    /**
     * 客户编号
     */
    @Id
    @Column(name = "customer_id")
    @GeneratedValue(generator = "JDBC")
    private Integer customerId;

    /**
     * 客户姓名
     */
    @Column(name = "customer_name")
    private String customerName;

    /**
     * 客户年龄
     */
    @Column(name = "customer_age")
    private Integer customerAge;

    /**
     * 客户性别：1男，2女
     */
    @Column(name = "customer_sex")
    private Short customerSex;

    /**
     * 客户电话
     */
    @Column(name = "customer_phone")
    private String customerPhone;

    /**
     * 客户意向楼盘
     */
    @Column(name = "customer_intention_property")
    private String customerIntentionProperty;

    /**
     * 客户添加时间
     */
    @Column(name = "customer_createtime")
    private String customerCreatetime;

    /**
     * 客户失效时间
     */
    @Column(name = "customer_failuretime")
    private String customerFailuretime;

    /**
     * 客户购房时间
     */
    @Column(name = "customer_purchase_date")
    private String customerPurchaseDate;

    /**
     * 客户对应用户编号
     */
    @Column(name = "user_id")
    private Integer userId;
}