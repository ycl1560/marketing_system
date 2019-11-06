package com.yunhang.marketing_system.service;

import com.yunhang.marketing_system.entity.BuildingInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yunhang.marketing_system.mapper.BuildingInfoMapper;

import java.util.List;

/**
 * @author 杨春路
 * @data 2019/10/29 17:29
 */
@Service
public class BuildingInfoService {

    @Resource
    private BuildingInfoMapper buildingInfoMapper;

    /**
     * 添加楼盘信息
     *
     * @param buildingInfo
     * @return
     */
    public int insertBuildings(BuildingInfo buildingInfo) {
        return buildingInfoMapper.insertSelective(buildingInfo);
    }

    /**
     * 更新楼盘信息
     *
     * @param buildingInfo
     * @return
     */
    public int updateBuildings(BuildingInfo buildingInfo) {

        return buildingInfoMapper.updateByPrimaryKeySelective(buildingInfo);
    }

    /**
     * 删除楼盘信息
     *
     * @param buildingId
     * @return
     */
    public int deleteBuildings(int buildingId) {
        return buildingInfoMapper.deleteByPrimaryKey(buildingId);
    }

    /**
     * 查询所有楼盘信息
     *
     * @return
     */
    public List<BuildingInfo> selectAllBuildings() {
        return buildingInfoMapper.selectAll();
    }

    /**
     * 查询所有楼盘信息
     *
     * @param buildingId
     * @return
     */
    public BuildingInfo selectBuildingInfoById(int buildingId) {
        return buildingInfoMapper.selectByPrimaryKey(buildingId);
    }
}

