package sinosoft.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sinosoft.realm.CustomRealm;
import sinosoft.session.CustomSessionManager;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author 王江超
 * @Date 2020/3/5 23:40
 * @Description:
 */
@Configuration
public class ShiroConfiguration {

    //1.创建realm
    @Bean
    public CustomRealm getRealm() {
        return new CustomRealm();
    }

    //2.创建安全管理器
    @Bean
    public SecurityManager getSecurityManager(CustomRealm customRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager(customRealm);
        //将自定义的会话管理器  注册到安全管理器
        securityManager.setSessionManager(sessionManager());

        //将自定义的redis缓存管理器注册到安全管理器中
        securityManager.setCacheManager(redisCacheManager());
        return securityManager;
    }
    //3.配置shiro过滤器工厂

    /**
     * web程序中，shiro进行权限控制  都是通过一组过滤器集合进行控制的
     *
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        //1.创建过滤器工厂
        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
        //2.设置安全管理器
        filterFactoryBean.setSecurityManager(securityManager);
        /**
         * 添加过滤拦截
         *
         */
        filterFactoryBean.setLoginUrl("/autherror?code=1");//跳转 url 地址
        filterFactoryBean.setUnauthorizedUrl("/autherror?code=2");//未授权页面
        //3.通用配置（跳转登录页面，为授权跳转页面）
        //4.设置过滤器集合
        /**
         * 设置所有的过滤器   有顺序map
         *    key  拦截的url地址
         *    value 过滤器类型
         *
         */
        Map<String, String> filterMap = new LinkedHashMap<String, String>();
        //filterMap.put("/user/home", "anon");  //当前地址可以匿名访问
        //必须具备权限
        // filterMap.put("/user/home","perms[user-home]");  //不具备指定权限  跳转到UnauthorizedUrl
        //具有某种权限才能访问
        //使用过滤器的形式  配置请求地址的依赖权限
        // filterMap.put("/user/home","perms[user-home]");
        //使用过滤器的形式  配置请求地址依赖角色
//        filterMap.put("/user/home", "roles[系统管理员]");

        filterMap.put("/user/**", "authc");//认证之后可以访问

        filterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return filterFactoryBean;
    }


    //5.开启shiro注解的支持
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }



    //  自定义会话管理器
    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    //1.redis控制器操作redis
    public RedisManager redisManager(){
        RedisManager redisManager = new RedisManager();
        redisManager.setHost(host);
        redisManager.setPort(port);
        redisManager.setDatabase(9);
        return redisManager;
    }
    //2.SessionDao

    public RedisSessionDAO redisSessionDAO(){
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        redisSessionDAO.setRedisManager(redisManager());
        return redisSessionDAO;
    }
    //3.会话管理器

    public DefaultWebSessionManager sessionManager(){
        CustomSessionManager sessionManager = new CustomSessionManager();
        sessionManager.setSessionDAO(redisSessionDAO());
        return sessionManager;
    }
    //4.缓存管理器
    public RedisCacheManager redisCacheManager(){
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        redisCacheManager.setRedisManager(redisManager());
        return redisCacheManager;
    }
}
