package com.yunhang.marketing_system.controller;

import com.yunhang.marketing_system.entity.CustomerInfo;
import com.yunhang.marketing_system.service.CustomerInfoService;
import com.yunhang.marketing_system.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

/**
 * @author 杨春路
 * @data 2019/10/31 17:51
 */
@RestController
public class CustomerController {
    @Autowired
    private CustomerInfoService customerInfoService;

    /**
     * 添加客户信息，所有人都可以添加
     * @param customer
     * @return
     */
    @RequestMapping("/addcustomerinfo")
    public JsonResult addCustomerInfo(@RequestBody CustomerInfo customer) throws ParseException {
        int mark = customerInfoService.addCustomer(customer);
        if (mark > 0)
           return JsonResult.ok("客户信息添加成功");

        return JsonResult.errorMsg("客户信息添加失败");
    }

    /**
     * 更新客户信息，所有人都可更新
     * @param customer
     * @return
     */
    @RequestMapping("/updatecustomerinfo")
    public JsonResult updateCustomerInfo(@RequestBody CustomerInfo customer){
        int mark=customerInfoService.updateCustomer(customer);
        if (mark > 0)
            return JsonResult.ok("客户信息更新成功");

        return JsonResult.errorMsg("客户信息更新失败");
    }

    /**
     * 删除客户信息，仅管理员可以操作
     * @param customerId
     * @return
     */
    @RequestMapping("/deletecustomerinfo")
    public JsonResult deleteCustomer(@RequestParam("customerId") int customerId){
        int mark=customerInfoService.deleteCustomer(customerId);
        if (mark > 0)
            return JsonResult.ok("客户删除成功");

        return JsonResult.errorMsg("客户删除失败");
    }

    /**
     * 查询所有客户信息，所有角色都有权限
     * @return
     */
    @RequestMapping("/selectallcustomerinfo")
    public JsonResult queryAllCustomer(){
        return JsonResult.ok(customerInfoService.queryAllCustomer());
    }

    /**
     * 查询单个客户信息ById，所有角色都有权限
     */
    @RequestMapping("/selectcustomerinfbyid")
    public JsonResult queryCustomerById(@RequestParam("customerId") int customerId){
        return JsonResult.ok(customerInfoService.queryCustomerById(customerId));
    }

}
