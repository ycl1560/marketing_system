package com.yunhang.marketing_system.entity;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;

/**
 * @author 杨春路
 * @data 2019/10/31 18:43
 */
@Data
@Table(name = "building_info")
public class BuildingInfo {
    /**
     * 楼盘编号
     */
    @Id
    @Column(name = "building_id")
    @GeneratedValue(generator = "JDBC")
    private Integer buildingId;

    /**
     * 楼盘名称
     */
    @Column(name = "building_name")
    private String buildingName;

    /**
     * 楼盘地址
     */
    @Column(name = "building_address")
    private String buildingAddress;

    /**
     * 楼盘所在地邮编
     */
    @Column(name = "building_postcode")
    private String buildingPostcode;

    /**
     * 楼盘所处环线
     */
    @Column(name = "building_rings")
    private Integer buildingRings;

    /**
     * 楼盘电话
     */
    @Column(name = "building_phone")
    private String buildingPhone;

    /**
     * 楼盘状态：1在售，2未售，3售完，4在租，5其他
     */
    @Column(name = "building_sole_state")
    private Short buildingSoleState;

    /**
     * 物业类别(普通住宅、别墅、公寓、经济舒适房、商住楼、其他)
     */
    @Column(name = "building_property_type")
    private String buildingPropertyType;

    /**
     * 建筑类别：板楼、塔楼、板塔结合、独栋、联排、双拼、并联、其他
     */
    @Column(name = "building_type")
    private String buildingType;

    /**
     * 房屋现状：1:期房 2:现房
     */
    @Column(name = "building_state")
    private Short buildingState;

    /**
     * 房屋装修情况：1全装修，2精装修，3菜单式，4厨卫装修，5毛坯，6初装修，7粗装饰，8公共部分精装修
     */
    @Column(name = "building_decoration_states")
    private String buildingDecorationStates;

    /**
     * 楼盘开发周期
     */
    @Column(name = "building_development_cycle")
    private String buildingDevelopmentCycle;

    /**
     * 楼盘开工日期
     */
    @Column(name = "building_starting_date")
    private String buildingStartingDate;

    /**
     * 楼盘竣工日期
     */
    @Column(name = "building_completion_date")
    private String buildingCompletionDate;

    /**
     * 开盘日期
     */
    @Column(name = "building_opening_time")
    private String buildingOpeningTime;

    /**
     * 入住日期
     */
    @Column(name = "building_checkin_date")
    private String buildingCheckinDate;

    /**
     * 楼盘占地面积
     */
    @Column(name = "building_floor_space")
    private Double buildingFloorSpace;

    /**
     * 建筑面积
     */
    @Column(name = "building_area")
    private Double buildingArea;

    /**
     * 容积率
     */
    @Column(name = "building_volume_ratio")
    private Double buildingVolumeRatio;

    /**
     * 绿化率
     */
    @Column(name = "building_green_rate")
    private Double buildingGreenRate;

    /**
     * 楼层状况(层数，步梯还是电梯，一层几户)
     */
    @Column(name = "building_floor_state")
    private String buildingFloorState;

    /**
     * 总户数
     */
    @Column(name = "`building_ householder_number`")
    private Integer buildingHouseholderNumber;

    /**
     * 车位数量
     */
    @Column(name = "building_parking_number")
    private Integer buildingParkingNumber;

    /**
     * 出售价格
     */
    @Column(name = "building_selling_price")
    private String buildingSellingPrice;

    /**
     * 出租价格
     */
    @Column(name = "building_rent_prices")
    private String buildingRentPrices;

    /**
     * 物业费
     */
    @Column(name = "building_property_fee")
    private String buildingPropertyFee;

    /**
     * 物业公司
     */
    @Column(name = "building_property_company")
    private String buildingPropertyCompany;

    /**
     * 配套设施
     */
    @Column(name = "building_supporting_facilities")
    private String buildingSupportingFacilities;

    /**
     * 公摊面积
     */
    @Column(name = "building_equally_shared_area")
    private Double buildingEquallySharedArea;
}