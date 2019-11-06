package com.yunhang.marketing_system.controller;

import com.yunhang.marketing_system.dto.UserInfoDto;
import com.yunhang.marketing_system.entity.UserInfo;
import com.yunhang.marketing_system.service.BossInfoService;
import com.yunhang.marketing_system.service.UserInfoService;
import com.yunhang.marketing_system.utils.JsonResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 杨春路
 * @data 2019/10/29 17:31
 */
@RestController
public class LoginController {
    @Autowired
    private UserInfoService userInfoService;

    /**
     * 未执行登陆时访问的页面
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult defaultLogin() {
        return JsonResult.errorMsg("请先登陆");
    }

    /**
     * 用户登陆
     * @param userName
     * @param userPassword
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult Login(@RequestParam("userName") String userName, @RequestParam("userPassword") String userPassword){
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(userName, userPassword);
        UserInfoDto userInfoDto=userInfoService.selectUserByUserNameDto(userName);
        // 执行认证登陆
        try {
            subject.login(token);
        } catch (UnknownAccountException uae) {
            return JsonResult.errorMsg("未知账户");
        } catch (IncorrectCredentialsException ice) {
            return JsonResult.errorMsg("密码不正确");
        } catch (LockedAccountException lae) {
            return JsonResult.errorMsg("账户已锁定");
        } catch (ExcessiveAttemptsException eae) {
            return JsonResult.errorMsg("用户名或密码错误次数过多");
        } catch (AuthenticationException ae) {
            return JsonResult.errorMsg("用户名或密码不正确！");
        }
        if (subject.isAuthenticated()) {
            return JsonResult.build(200,"登陆成功",userInfoDto );
        } else {
            token.clear();
            return JsonResult.errorMsg("登录失败");
        }
    }
}
