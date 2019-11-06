package com.yunhang.marketing_system.utils;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import com.yunhang.marketing_system.service.FileService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author 杨春路
 * @data 2019/11/1 10:13
 */
@Api(tags = "图片上传接口")
public  class UploadFileUtil {

    @Value("${baseUploadUrl}")
    private String url;

    @Autowired
    private UploadManager uploadManager;

    @Autowired
    private Auth auth;


    @Value("${qiniu.bucket}")
    private String bucket;


    private StringMap putPolicy;
    public  String uploadImg(MultipartFile upfile) throws IOException {
        String fileName = upfile.getOriginalFilename();
        File file = new File(url + fileName);
        try{
            //将MulitpartFile文件转化为file文件格式
            upfile.transferTo(file);
            String imageName= uploadFile(file);
            return imageName;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public String uploadFile(File file) throws QiniuException {
        Response response = this.uploadManager.put(file,null,getUploadToken());
        //解析上传的结果
        DefaultPutRet putRet = new Gson().fromJson(response.bodyString(),DefaultPutRet.class);

        String imageName = putRet.hash;
        int retry = 0;
        while(response.needRetry() && retry < 3){
            response = this.uploadManager.put(file,null,getUploadToken());
        }
        return imageName;
    }

    private String getUploadToken(){
        return this.auth.uploadToken(bucket,null,3600,putPolicy);
    }

}
