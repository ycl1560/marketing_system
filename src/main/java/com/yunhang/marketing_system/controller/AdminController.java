package com.yunhang.marketing_system.controller;

import com.yunhang.marketing_system.entity.UserInfo;
import com.yunhang.marketing_system.service.UserInfoService;
import com.yunhang.marketing_system.utils.JsonResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 杨春路
 * @data 2019/10/29 18:20
 */
@RestController
public class AdminController {
    @Autowired
    private UserInfoService userInfoService;

    /**
     * 修改管理员密码
     * @param userPassword
     * @return
     */
    @RequiresPermissions("adminManage")
    @ResponseBody
    @RequestMapping(value = "/modifyadminpassword", method = RequestMethod.POST)
    public JsonResult modifyAdminPassword(@RequestParam("userPassword") String userPassword) {
        String userName="admin";
        int mark=userInfoService.updateAdminPasswordByUserName(userName,userPassword);
        if (mark>0)
            return JsonResult.ok("密码修改成功！") ;
        else
            return JsonResult.errorMsg("修改失败！");
    }



}
