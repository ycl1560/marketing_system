package com.yunhang.marketing_system.controller;
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

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

/**
 * @author 杨春路
 * @data 2019/11/1 14:06
 */
@RestController
@Api(tags = "图片上传接口")
public class UploadController {
    @Resource
    private FileService fileService;

    /**
     * 文件上传服务器，返回文件地址，可将此地址存入数据库
     * @param upfile
     * @return
     * @throws IOException
     */
    @PostMapping("/uploadfile")
    @ApiOperation(value = "单个图片上传到七牛云")
    public JsonResult uploaduserimg(@RequestParam(value = "file") MultipartFile upfile) throws IOException {

            String fileAddress= fileService.uploadFile(upfile);
            return JsonResult.ok(fileAddress);


    }
}
