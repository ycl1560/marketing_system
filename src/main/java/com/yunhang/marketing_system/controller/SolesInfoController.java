package com.yunhang.marketing_system.controller;

import com.yunhang.marketing_system.dto.BusinessInfoAndUserInfoDto;
import com.yunhang.marketing_system.dto.BusinessInfoDto;
import com.yunhang.marketing_system.dto.SolesInfoAndUserInfoDto;
import com.yunhang.marketing_system.dto.SolesInfoDto;
import com.yunhang.marketing_system.entity.BusinessManagerInfo;
import com.yunhang.marketing_system.entity.SolesInfo;
import com.yunhang.marketing_system.service.SaleRecordInfoService;
import com.yunhang.marketing_system.service.SolesInfoService;
import com.yunhang.marketing_system.utils.JsonResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 杨春路
 * @data 2019/10/31 17:02
 */
@RestController
public class SolesInfoController {
    @Autowired
    private SolesInfoService solesInfoService;

    /**
     * 添加销售员信息，可用角色管理员，Boss，商务经理
     * @param solesInfoAndUserInfoDto
     * @return
     */
    @RequiresPermissions("solesAddAndDelete")
    @RequestMapping("/addsolesinfo")
    public JsonResult insertSolesInfo(@RequestBody SolesInfoAndUserInfoDto solesInfoAndUserInfoDto){
        if(solesInfoAndUserInfoDto.getUserName()==null||solesInfoAndUserInfoDto.getUserPassword()==null)
        {
            return JsonResult.errorMsg("请输入用户名和密码");
        }
        int mark=solesInfoService.insertSolesInfo(solesInfoAndUserInfoDto);
        if (mark>2)
            if (mark>2)
            {
                return JsonResult.ok("销售员添加成功！");
            }
        return JsonResult.errorMsg("销售员添加失败，用户名已存在！");
    }

    /**
     * 更新销售员信息，角色权限管理员，Boss，商务经理
     * @param solesInfo
     * @return
     */
    @RequiresPermissions("solesUpdateAndQueryOne")
    @RequestMapping(value = "/updatesolesinfobyid", method = RequestMethod.POST)
    public JsonResult updateSolesInfoById(@RequestBody SolesInfo solesInfo){
        int mark=solesInfoService.updateSolesInfoById(solesInfo);
        if (mark > 0)
            return JsonResult.ok("销售员信息更新成功！");
        else
            return JsonResult.errorMsg("销售员信息更新失败！");
    }

    /**
     * 删除销售员信息
     * @param solesId
     * @return
     */
    @RequiresPermissions("solesAddAndDelete")
    @RequestMapping("/deletesolesinfobyid")
    public JsonResult deleteSolesInfoById(@RequestParam("solesId") int solesId) {
        int mark=solesInfoService.deleteSolesInfoById(solesId);
        if (mark>2)
            return JsonResult.ok("销售员删除成功！") ;
        else
            return JsonResult.errorMsg("销售员删除失败，用户名不存在！");
    }

    /**
     * 查询所有销售员信息，可用角色管理员，Boss，商务经理
     * @return
     */
    @RequiresPermissions("queryAllSoles")
    @RequestMapping("/selectallsolesinfo")
    public JsonResult queryAllSolesInfo(){
        List<SolesInfoDto> solesInfoDtos=solesInfoService.queryAllSolesInfo();
        return JsonResult.ok(solesInfoDtos);
    }

    /**
     * 查询单个销售员信息ById，可用角色：管理员，Boss，商务经理，销售员
     * @param solesId
     * @return
     */
    @RequiresPermissions("solesUpdateAndQueryOne")
    @RequestMapping("/querysoleinfobyid")
    public JsonResult querySoleInfoById(@RequestParam("solesId") int solesId){
        SolesInfoDto solesInfoDto=solesInfoService.querySoleInfoById(solesId);
        return JsonResult.ok(solesInfoDto);
    }






}
