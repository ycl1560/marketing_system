package com.yunhang.marketing_system.controller;

import com.yunhang.marketing_system.dto.BossInfoAndUserInfoDto;
import com.yunhang.marketing_system.dto.BossInfoDto;
import com.yunhang.marketing_system.dto.BusinessInfoAndUserInfoDto;
import com.yunhang.marketing_system.dto.BusinessInfoDto;
import com.yunhang.marketing_system.entity.BossInfo;
import com.yunhang.marketing_system.entity.BusinessManagerInfo;
import com.yunhang.marketing_system.service.BusinessManagerInfoService;
import com.yunhang.marketing_system.utils.JsonResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 杨春路
 * @data 2019/10/31 11:02
 */
@RestController
public class BusinessManagerInfoController {
    @Autowired
    private BusinessManagerInfoService businessManagerInfoService;

    /**
     * 添加商务经理，可用角色有管理员，Boss
     * @param businessInfoAndUserInfoDto
     * @return
     */
    @RequiresPermissions("businessAddAndDelete")
    @RequestMapping("/addbusinessinfo")
    public JsonResult insertBusinessManagerInfo(@RequestBody BusinessInfoAndUserInfoDto businessInfoAndUserInfoDto){
        if (businessInfoAndUserInfoDto.getUserName()==null||businessInfoAndUserInfoDto.getUserPassword()==null)
        {
            return JsonResult.errorMsg("请输入用户名和密码");
        }
        int mark=businessManagerInfoService.insertBusinessManagerInfo(businessInfoAndUserInfoDto);
        if (mark>2)
            if (mark>2)
            {
                return JsonResult.ok("商务经理添加成功！");
            }
        return JsonResult.errorMsg("商务经理添加失败，用户名已存在！");
    }

    /**
     * 更新商务经理信息ById，可用角色管理员，Boss，商务经理
     * @param businessManagerInfo
     * @return
     */
    @RequiresPermissions("businessUpdateAndQueryOne")
    @RequestMapping(value = "/updatebusinessmanagerinfobyid", method = RequestMethod.POST)
    public JsonResult updateBusinessInfo(@RequestBody BusinessManagerInfo businessManagerInfo) {
        int mark = businessManagerInfoService.updateBusinessInfo(businessManagerInfo);
        if (mark > 0)
            return JsonResult.ok("商务经理信息更新成功！");
        else
            return JsonResult.errorMsg("商务经理信息更新失败！");
    }

    /**
     * 删除商务经理信息ById，可用角色管理员，Boss
     * @param businessManagerId
     * @return
     */
    @RequiresPermissions("businessAddAndDelete")
    @RequestMapping("/deleteBusinessInfoById")
    public JsonResult deleteBusinessManagerInfo(@RequestParam("businessManagerId") int businessManagerId){
        int mark=businessManagerInfoService.deleteBusinessInfoById(businessManagerId);
        System.out.println(mark);
        if (mark>2)
            return JsonResult.ok("商务经理删除成功！") ;
        else
            return JsonResult.errorMsg("商务经理删除失败，用户名不存在！");
    }


    /**
     * 查询所有商务经理信息，可用角色管理员，Boss
     * @return
     */
    @RequiresPermissions("queryAllBusiness")
    @RequestMapping("/selectallbusinessmanagerinfo")
    public JsonResult queryAllBusinessManagerInfo(){
        List<BusinessInfoDto> businessInfoDtos= businessManagerInfoService.queryAllBusinessManagerInfo();
        return JsonResult.ok(businessInfoDtos);
    }

    /**
     * 查询单个商务经理信息ById，可用角色：管理员，Boss，商务经理
     * @param businessManagerId
     * @return
     */
    @RequiresPermissions("businessUpdateAndQueryOne")
    @RequestMapping("/querybusinessinfobyid")
    public JsonResult queryBusinessInfoById(@RequestParam("businessManagerId") int businessManagerId){
        BusinessInfoDto businessInfoDto=businessManagerInfoService.queryBusinessInfoById(businessManagerId);
        return JsonResult.ok(businessInfoDto);
    }
}
