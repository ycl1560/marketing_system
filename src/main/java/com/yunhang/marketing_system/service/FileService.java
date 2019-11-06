package com.yunhang.marketing_system.service;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import com.yunhang.marketing_system.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author 杨春路
 * @data 2019/11/1 11:20
 */
@Service
public class FileService {
    @Autowired
    private UploadManager uploadManager;

    @Autowired
    private Auth auth;


    @Value("${qiniu.bucket}")
    private String bucket;

    @Value("${baseUploadUrl}")
    private String url;

    @Value("${uploadFileServiceAdress}")
    private String uploadFileServiceAdress;

    private StringMap putPolicy;



    public String uploadFile(MultipartFile upfile) throws IOException {


        String fileName = upfile.getOriginalFilename();
        File file = new File(url + fileName);
        upfile.transferTo(file);

        Response response = this.uploadManager.put(file,null,getUploadToken());
        //解析上传的结果
        DefaultPutRet putRet = new Gson().fromJson(response.bodyString(),DefaultPutRet.class);

        String imageName = putRet.hash;
        int retry = 0;
        while(response.needRetry() && retry < 3){
            response = this.uploadManager.put(file,null,getUploadToken());
        }
        file.delete();
        return uploadFileServiceAdress+'/'+imageName;
    }



    private String getUploadToken(){
        return this.auth.uploadToken(bucket,null,3600,putPolicy);
    }



}
