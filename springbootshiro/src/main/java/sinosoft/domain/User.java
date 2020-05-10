package sinosoft.domain;

import lombok.Data;
import org.crazycake.shiro.AuthCachePrincipal;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Set;

/**
 * @Author 王江超
 * @Date 2020/3/5 23:20
 * @Description:
 *
 * AuthCachePrincipal   redis和shiro插件包
 */
@Data
public class User implements Serializable, AuthCachePrincipal {

    private int id;

    private String userName;

    private String password;

    private Set<Role> roles;


    public String getAuthCacheKey() {
        return null;
    }
}
