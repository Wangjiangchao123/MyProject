package com.example.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 王江超
 * @Date 2020/3/5 15:54
 * @Description: 自定义Realm对象
 * <p>
 * 继承 AuthorizingRealm
 * 重写方法
 * doGetAuthorizationInfo：授权
 * 获取用户授权数据
 * doGetAuthenticationInfo ：认证
 * 根据用户名密码登录，将数据保存
 */
public class PermissionRealm extends AuthorizingRealm {

    /**
     * 自定义Realm名称
     *
     * @param name
     */

    public void setName(String name) {
        super.setName("permissionRealm");
    }

    //授权   根据认证的数据  获取用户权限信息

    /**
     * @param principalCollection 包含了所有已经认证的安全数据
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        /**
         *
         * 2、根据id或者名称查询用户
         * 3、查询用户的角色和权限信息
         * 4、构造返回
         */
        System.out.println("执行授权");
        //1、获取安全数据 username ，用户id
        String username = (String) principalCollection.getPrimaryPrincipal();
//        2、根据id或者名称查询用户
//                * 3、查询用户的角色和权限信息
        List<String> perms = new ArrayList<String>();
        perms.add("user:save");
        perms.add("user:update");

        List<String> roles = new ArrayList<String>();
        roles.add("role1");
        roles.add("role2");
//                * 4、构造返回
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //设置权限集合
        info.addStringPermissions(perms);
        //设置角色集合
        return info;
    }


    //认证   比较用户名 密码和数据库是否一致
    //  将安全数据保存shiro 进行保管
    //
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证");
        //1、构造uptoken
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //2、获取用户输入的用户名密码
        String username = token.getUsername();
        String password = new String(token.getPassword());
        //3、根据用户名查询数据
        //4、比较密码和数据库中是否一致
        if ("123456".equals(password)) {
            //5、如果成功，向shiro存入安全数据
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, password, getName());
            return info;
        } else {
            throw new RuntimeException("用户名或者密码错误");
            //6、失败 抛出异常或者null
        }
    }
}
