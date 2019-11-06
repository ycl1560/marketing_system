package com.yunhang.marketing_system.exception;
import com.yunhang.marketing_system.utils.JsonResult;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;

/**
 * @author 杨春路
 * @data 2019/10/29 18:34
 */
@ControllerAdvice
public class NoPermissionException {
    @ResponseBody
    @ExceptionHandler(UnauthorizedException.class)
    public JsonResult handleShiroException(Exception ex) {
        return JsonResult.errorMsg("无权限");
    }
    @ResponseBody
    @ExceptionHandler(AuthorizationException.class)
    public JsonResult AuthorizationException(Exception ex) {
        return JsonResult.errorMsg("权限认证失败");
    }
    @ResponseBody
    @ExceptionHandler(ParseException.class)
    public JsonResult ParseException(Exception ex) {
        return JsonResult.errorMsg("日期认证失败");
    }@ResponseBody
    @ExceptionHandler(NullPointerException.class)
    public JsonResult NullPointerException(Exception ex) {
        return JsonResult.errorMsg("空指针异常，请检查传入值或数据库记录是否存在！");
    }

}
