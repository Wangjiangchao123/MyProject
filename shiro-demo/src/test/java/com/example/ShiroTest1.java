package com.example;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * @Author 王江超
 * @Date 2020/3/5 15:05
 * @Description:
 */
public class ShiroTest1 {

    /**
     * 测试用户认证
     *
     *      认证：用户登录
     *      1、根据配置文件创建SecurityManagerFactory
     *      2、通过工厂获取SecurityManager
     *      3、将SecurityManager绑定到当前的运行环境
     *      4、从当前环境中构建出subject
     *      5、构造shiro的登录数据
     *      6、主体登录
     *
     */

    /**
     * 用户认证
     */
    @Test
    public void testLogin(){

        //1、根据配置文件创建SecurityManagerFactory
        IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro-test.ini");
        //2、通过工厂获取SecurityManager
        SecurityManager securityManager = factory.getInstance();
        //3、将Security绑定到当前运行环境
        SecurityUtils.setSecurityManager(securityManager);
        //4、从当前环境中构造出主体
        Subject subject = SecurityUtils.getSubject();
        //5、构造shiro登录的数据
        String username = "zhangsan";
        String password = "123456";
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        //6、主体登录
        subject.login(token);


        //7、验证用户是否登录成功
        System.out.println("用户是否登录成功"+subject.isAuthenticated());
        //8、获取登录的数据
        System.out.println("登录成功的数据="+subject.getPrincipal());

    }













}
