package com.yunhang.marketing_system.APPcontroller;

import com.yunhang.marketing_system.entity.CustomerInfo;
import com.yunhang.marketing_system.service.CustomerInfoService;
import com.yunhang.marketing_system.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 杨春路
 * @data 2019/11/1 10:00
 */
@RestController
public class AppCustomerController {

    @Autowired
    private CustomerInfoService customerInfoService;

    /**
     * app查询用户旗下所有客户信息ByUserId
     * @param userId
     * @return
     */
    @RequestMapping("/appquerycustomerbyuserid")
    public JsonResult appQueryAllCustomerInfo(@RequestParam("userId") int userId){
        List<CustomerInfo> customerInfos=customerInfoService.queryCustomerByUserId(userId);
        return JsonResult.ok(customerInfos);
    }
}
