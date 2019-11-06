package com.yunhang.marketing_system.controller;

import com.yunhang.marketing_system.entity.SaleRecordInfo;
import com.yunhang.marketing_system.service.SaleRecordInfoService;
import com.yunhang.marketing_system.utils.JsonResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 杨春路
 * @data 2019/10/31 13:12
 */
@RestController
public class SalesRecordController {
    @Resource
    private SaleRecordInfoService saleRecordInfoService;

    /**
     * 销售记录查询ByUserId
     * @param userId
     * @return
     */
    @RequestMapping("/selectsalerecordbyuserid")
    public JsonResult salesRecordQueryByUserId(@RequestParam("userId") String userId){
        List<SaleRecordInfo> saleRecordInfos=saleRecordInfoService.selectSaleRecordByUserId(userId);
        return JsonResult.ok(saleRecordInfos);
    }

    /**
     * 销售记录按日期筛选，传入userId和saleTime(格式为2019-10)
     * @param saleRecordInfo
     * @return
     */
    @RequestMapping("/selectsalerecordbyuseridanddata")
    public JsonResult salesRecordQueryByUserIdAndDate(@RequestBody SaleRecordInfo saleRecordInfo){
        List<SaleRecordInfo> saleRecordInfos=saleRecordInfoService.selectSaleRecordByUserIdAndDate(saleRecordInfo);
        return JsonResult.ok(saleRecordInfos);
    }

    /**
     * 销售记录添加，代表购房成功
     * @return
     */
  /*  public JsonResult addSalesRecordByUserId(){
        saleRecordInfoService.addSaleRecordByUserId(){

        }
    }
*/

}
