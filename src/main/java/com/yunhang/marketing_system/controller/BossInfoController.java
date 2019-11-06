package com.yunhang.marketing_system.controller;

import com.yunhang.marketing_system.dto.BossInfoAndUserInfoDto;
import com.yunhang.marketing_system.dto.BossInfoDto;
import com.yunhang.marketing_system.entity.BossInfo;
import com.yunhang.marketing_system.entity.UserInfo;
import com.yunhang.marketing_system.service.BossInfoService;
import com.yunhang.marketing_system.service.UserInfoService;
import com.yunhang.marketing_system.utils.JsonResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 杨春路
 * @data 2019/10/30 15:58
 */
@RestController
public class BossInfoController {
    @Autowired
    private BossInfoService bossInfoService;

    /**
     * 添加Boss信息，可用角色：管理员
     * @param bossInfoAndUserInfoDto
     * @return
     */
    @RequiresPermissions("bossAddAndDelete")
    @RequestMapping(value = "/addbossinfo", method = RequestMethod.POST)
    public JsonResult insertBossInfo(@RequestBody BossInfoAndUserInfoDto bossInfoAndUserInfoDto) {

        if(bossInfoAndUserInfoDto.getUserName()==null||bossInfoAndUserInfoDto.getUserPassword()==null)
        {
            return JsonResult.errorMsg("请输入用户名和密码");
        }
        int mark=bossInfoService.insertBossInfo(bossInfoAndUserInfoDto);
        if (mark>2)
        {
            return JsonResult.ok("Boss添加成功！");
        }
        return JsonResult.errorMsg("Boss添加失败，用户名已存在！");
    }

    /**
     * 更新Boss信息ById，可用角色：管理员，Boss
     * @param bossInfo
     * @return
     */
    @RequiresPermissions("bossUpdateAndQueryOne")
    @RequestMapping(value = "/updatebossinfobyid", method = RequestMethod.POST)
    public JsonResult updateBossInfo(@RequestBody BossInfo bossInfo) {


        int mark=bossInfoService.updateBossInfo(bossInfo);
        if (mark>0)
            return JsonResult.ok("Boss信息更新成功！") ;
        else
            return JsonResult.errorMsg("Boss信息更新失败！");
    }

    /**
     * 删除Boss信息ById，可用角色：管理员
     * @param bossId
     * @return
     */
    @RequiresPermissions("bossAddAndDelete")
    @RequestMapping(value = "/deletebossinfo", method = RequestMethod.POST)
    public JsonResult DeleteBossInfo(@RequestParam("bossId") int bossId) {
        int mark=bossInfoService.deleteBossInfoById(bossId);
        if (mark>2)
            return JsonResult.ok("Boss删除成功！") ;
        else
            return JsonResult.errorMsg("Boss删除失败，用户名不存在！");
    }

    /**
     * 查询所有Boss信息，可用角色：管理员
     * @return
     */
    @RequiresPermissions("queryAllBoss")
    @RequestMapping("/queryallbossinfo")
    public JsonResult queryAllBossInfo(){
        List<BossInfoDto> bossInfoDtos=bossInfoService.queryAllBossInfo();
        return JsonResult.ok(bossInfoDtos);
    }

    /**
     * 查询单个Boss信息ById，可用角色：管理员，Boss
     * @param bossId
     * @return
     */
    @RequiresPermissions("bossUpdateAndQueryOne")
    @RequestMapping("/querybossinfobyid")
    public JsonResult queryBossInfoById(@RequestParam("bossId") int bossId){
        BossInfoDto bossInfoDto=bossInfoService.queryBossInfoById(bossId);
        return JsonResult.ok(bossInfoDto);
    }





}
