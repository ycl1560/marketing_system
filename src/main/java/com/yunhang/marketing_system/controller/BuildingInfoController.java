package com.yunhang.marketing_system.controller;

import com.yunhang.marketing_system.entity.BuildingInfo;
import com.yunhang.marketing_system.service.BuildingInfoService;
import com.yunhang.marketing_system.utils.JsonResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 杨春路
 * @data 2019/10/31 18:23
 */
@RestController
public class BuildingInfoController {

    @Autowired
    private BuildingInfoService buildingInfoService;

    /**
     * 添加楼盘信息，管理员和Boss有此权限
     * @param buildingInfo
     * @return
     */
    @RequiresPermissions("addupdatedeleteBuildings")
    @RequestMapping("/addbuildingsinfo")
    public JsonResult addBuildingsInfo(@RequestBody BuildingInfo buildingInfo){
        int mark=buildingInfoService.insertBuildings(buildingInfo);
        if(mark>0)
            return JsonResult.ok("楼盘信息添加成功");
        return JsonResult.errorMsg("楼盘信息添加失败");
    }

    /**
     * 更新楼盘信息，管理员和Boss有此权限
     * @param buildingInfo
     * @return
     */
    @RequiresPermissions("addupdatedeleteBuildings")
    @RequestMapping("/updatebuildingsinfobyid")
    public JsonResult updateBuildingsInfoById(@RequestBody BuildingInfo buildingInfo){
        int mark=buildingInfoService.updateBuildings(buildingInfo);
        if(mark>0)
            return JsonResult.ok("楼盘信息更新成功");
        return JsonResult.errorMsg("楼盘信息更新失败");
    }

    /**
     * 删除楼盘信息，管理员和Boss有此权限
     * @param buildingId
     * @return
     */
    @RequiresPermissions("addupdatedeleteBuildings")
    @RequestMapping("/deletebuildingsinfobyid")
    public JsonResult deleteBuildingsInfoById(@RequestParam("buildingId") int buildingId){
        int mark=buildingInfoService.deleteBuildings(buildingId);
        if(mark>0)
            return JsonResult.ok("楼盘删除成功");
        return JsonResult.errorMsg("楼盘删除失败");
    }

    /**
     * 查询所有楼盘信息
     * @return
     */
    @RequestMapping("/selectallbuildingsinfo")
    public JsonResult queryAllBuildingsInfo(){
       return JsonResult.ok(buildingInfoService.selectAllBuildings());
    }

    /**
     * 查询单个楼盘信息
      * @param buildingId
     * @return
     */
    @RequestMapping("/selectbuildingsinfobyid")
    public JsonResult queryBuildingsInfoById(@RequestParam("buildingId") int buildingId){
       return JsonResult.ok(buildingInfoService.selectBuildingInfoById(buildingId));
    }










}
