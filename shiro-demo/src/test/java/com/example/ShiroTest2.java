package com.example;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author 王江超
 * @Date 2020/3/5 15:05
 * @Description:
 */
public class ShiroTest2 {

    private SecurityManager securityManager;


    @Before
    public void init(){

        //1、根据配置文件创建SecurityManagerFactory
        IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro-test-2.ini");
        //2、通过工厂获取SecurityManager
        SecurityManager securityManager = factory.getInstance();
        //3、将Security绑定到当前运行环境
        SecurityUtils.setSecurityManager(securityManager);
    }

    /**
     * 用户认证
     */
    @Test
    public void testLogin(){
        Subject subject = SecurityUtils.getSubject();
        String username = "lisi";
        String password = "654321";
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        subject.login(token);

        //授权
        //登录之后完成授权   授权：检验当前用户是否有操作权限，是否具有某个角色
        System.out.println(subject.hasRole("role1"));
        System.out.println(subject.isPermitted("user:select"));


    }













}
