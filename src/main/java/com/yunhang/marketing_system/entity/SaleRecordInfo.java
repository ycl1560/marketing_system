package com.yunhang.marketing_system.entity;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;

/**
*@author 杨春路
*@data 2019/10/31 12:39
*/
@Data
@Table(name = "sale_record_info")
public class SaleRecordInfo {
    /**
     * 销售记录编号
     */
    @Id
    @Column(name = "sale_record_id")
    @GeneratedValue(generator = "JDBC")
    private Integer saleRecordId;

    /**
     * 用户编号
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 客户编号
     */
    @Column(name = "customer_id")
    private Integer customerId;

    /**
     * 房屋信息表编号
     */
    @Column(name = "room_info_id")
    private Integer roomInfoId;

    /**
     * 销售日期
     */
    @Column(name = "sale_time")
    private String saleTime;
}