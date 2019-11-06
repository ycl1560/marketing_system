package com.yunhang.marketing_system.APPcontroller;

import com.yunhang.marketing_system.dto.UserInfoDto;
import com.yunhang.marketing_system.service.FileService;
import com.yunhang.marketing_system.service.UserInfoService;
import com.yunhang.marketing_system.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @author 杨春路
 * @data 2019/11/1 9:09
 */
@RestController
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private FileService fileService;

    /**
     * 查询用户信息
     * @param userId
     * @return
     */
    @RequestMapping("/appqueryuserinfobyid")
    public JsonResult appQueryUserInfoByUserId(@RequestParam("userId") int userId){
        UserInfoDto userInfoDto=userInfoService.appSelectUserInfoById(userId);
        return JsonResult.ok(userInfoDto);
    }








}

