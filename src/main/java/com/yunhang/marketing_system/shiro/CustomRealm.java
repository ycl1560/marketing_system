package com.yunhang.marketing_system.shiro;

import com.yunhang.marketing_system.entity.PermissionsInfo;
import com.yunhang.marketing_system.entity.RolePermissions;
import com.yunhang.marketing_system.entity.UserInfo;
import com.yunhang.marketing_system.entity.UserRole;
import com.yunhang.marketing_system.service.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * @author 杨春路
 * @data 2019/10/29 17:38
 */
public class CustomRealm extends AuthorizingRealm {
    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private RolePermissionsService rolePermissionsService;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private RoleInfoService roleInfoService;

    @Autowired
    private PermissionsInfoService permissionsInfoService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        UserInfo user=(UserInfo) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        UserInfo userInfo=userInfoService.selectUserById(user.getUserId());
        //根据用户ID查询用户的所属角色，用户是Boss的同时也可以是员工，自己给自己做事嘛
        List<UserRole> userRoles=userRoleService.selectUserRoleByUserId(userInfo.getUserId());
        for (UserRole userRole : userRoles) {
            //根据用户角色查询用户的权限
            List<RolePermissions> rolePermissions=rolePermissionsService.selectRolePermissionByRoleId(userRole.getRoleId());

            for (RolePermissions rolePermission : rolePermissions) {
                String permission=permissionsInfoService.selectPermissionInfoByPermissionsId(rolePermission.getPermissionsId());
                info.addStringPermission(permission);
            }
        }
        return info;
        /*String username = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> stringSet = new HashSet<>();
        stringSet.add("user:show");
        stringSet.add("user:admin");
        stringSet.add("BussinessManage:showsolesinfo");
        stringSet.add("Boss:showbussinessmanageinfo");

        info.setStringPermissions(stringSet);
        return info;*/
    }

    /**
     * 这里可以注入userService,为了方便演示，我就写死了帐号了密码
     * private UserService userService;
     * <p>
     * 获取即将需要认证的信息
     */


    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("-------身份认证方法--------");
        String userName = (String) authenticationToken.getPrincipal();
        String userPwd = new String((char[]) authenticationToken.getCredentials());
        //根据用户名从数据库获取密码
        UserInfo userInfo = userInfoService.selectUserByUserName(userName);
        if (userName == null) {
            throw new AccountException("用户名不正确");
        } else if (!userPwd.equals(userInfo.getUserPassword() )) {
            throw new AccountException("密码不正确");
        }
        return new SimpleAuthenticationInfo(userInfo, userInfo.getUserPassword(),getName());
    }
}