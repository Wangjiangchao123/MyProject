package sinosoft.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import sinosoft.dao.UserMapper;
import sinosoft.domain.Permission;
import sinosoft.domain.Role;
import sinosoft.domain.User;
import sinosoft.service.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author 王江超
 * @Date 2020/3/5 23:08
 * @Description: 自定义 realm
 */
public class CustomRealm extends AuthorizingRealm {

    @Override
    public void setName(String name) {
        super.setName("customRealm");
    }

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    /**
     * 授权方法
     * 操作的时候，判断用户是否具有相应的权限
     * 先认证  --  安全数据
     * 再授权--  根据安全数据  获取用户具有的所有操作权限
     *
     * @param principalCollection 安全数据
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("用户授权。。。");
        //1、获取已认证的用户数据
        User user = (User) principalCollection.getPrimaryPrincipal();//得到唯一的安全数据
        //2、根据用户数据 获取用户权限信息（所有角色，所有权限）
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> roles = new HashSet<String>(); //所有角色
        Set<String> perms = new HashSet<String>();//所有权限
        //3、
        for(Role role : userMapper.getUserRoles(user.getUserName())){
            roles.add(role.getName());
            //权限
            Set<Permission> permission = userMapper.getRolePermission(role.getId());
                for (Permission perm : permission){
                    perms.add(perm.getCode());
                }
        }
        info.setStringPermissions(perms);
        info.setRoles(roles);
        return info;
    }

    /**
     * 认证方法
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException 传递的用户名和密码
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("用户认证。。。");
        //1、获取登录的用户名和密码
        UsernamePasswordToken uptoken = (UsernamePasswordToken) authenticationToken;
        String username = uptoken.getUsername();
        String password = new String(uptoken.getPassword());
        //2、根据用户名查询数据库
        User user = userService.findByName(username);
        //3、判断用户名是否存在或者密码是否一致
        if (user != null && user.getPassword().equals(password)) {
            //4、如果一致，返回安全数据
            //构造方法 ： 安全数据 密码  realm名
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());
            return info;
        } else {
            //5、不一致，返回null（抛出异常）
            return null;
        }
    }
}
