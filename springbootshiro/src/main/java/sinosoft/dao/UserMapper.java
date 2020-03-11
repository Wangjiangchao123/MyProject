package sinosoft.dao;


import org.apache.ibatis.annotations.*;
import sinosoft.domain.Permission;
import sinosoft.domain.Role;
import sinosoft.domain.User;

import java.util.List;
import java.util.Set;

/**
 * @Author 王江超
 * @Date 2020/3/9 11:03
 * @Description:
 */
@Mapper
public interface UserMapper {

    @Insert("insert into pd_user(username,password) values(#{name},#{pwd});")
    int addUser(@Param("name") String name, @Param("pwd") String pwd);

    @Select("select * from pd_user where username = #{name};")
    User findByName(@Param("name") String name);

    @Select("select id,name from pd_role where id in (select role_id from  pd_user_role where user_id in (select id from pd_user where username = #{username}))")
    Set<Role> getUserRoles(@Param("username") String username);


    @Select("select t.code from pd_permission t,pd_role_permission t1 where " +
            " t.id = t1.permission_id and t1.role_id =#{id};")
    Set<Permission> getRolePermission(@Param("id") int id);
}
