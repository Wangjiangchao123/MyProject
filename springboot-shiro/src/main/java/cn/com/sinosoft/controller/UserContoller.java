package cn.com.sinosoft.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

/**
 * @Author 王江超
 * @Date 2020/3/5 22:35
 * @Description:
 */
@RestController
public class UserContoller {

    //使用shiro 注解鉴权
    // @RequiresPermissions()   //  访问此方法必须具备的权限
    //@RequiresRoles()          //   访问此方法必须具备的角色

    /**
     * 用户鉴权的两种方式
     *          1、使用过滤器，如果权限信息不匹配  跳转到未授权地址
     *          2、使用注解  如果不匹配  抛出异常
     * @return
     */
    @RequiresPermissions("user-home")
    @RequestMapping("/user/home")
    public  String home(){
        return "返回个人主页成功";
    }



    @PostMapping("/user/add")
    public String add() {
        return "添加用户成功";
    }


    @GetMapping("/user")
    public String find() {
        return "查询用户成功";
    }

    @PutMapping("/user/{id}")
    public String update() {
        return "修改用户成功";
    }

    @DeleteMapping("/user/{id}")
    public String delete() {
        return "删除用户成功";
    }


    /**
     * 1、 传统登录
     * 前端发送请求 => 接口部分获取用户名密码 => 程序员在接口部分手动控制
     * <p>
     * 2、shiro 登录
     * 前端发送请求 => 接口部分获取用户名密码 => 通过subject.login =>realm域的认证方法
     *
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/login")
    public String login(String username, String password) {
        try {
            /**
             * 密码加密 ：shiro提供MD5加密
             *        Md5Hash：
             *          参数1：加密内容
             *          参数2：盐    （加密的混淆字符串）
             *          参数3：加密次数
             */
            password = new Md5Hash(password, username, 3).toString();

            // 1、构造登录令牌
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            // 2、获取subject
            Subject subject = SecurityUtils.getSubject();
            //3、调用subject进行登录
            subject.login(token);
            return "登录成功";
        } catch (Exception e) {
            return "用户名或密码错误";
        }
    }


    @RequestMapping("/autherror")
    public String autherror(int code) {
        return code == 1 ? "未登录" : "未授权";
    }

}
