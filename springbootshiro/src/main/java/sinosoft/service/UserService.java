package sinosoft.service;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Service;
import sinosoft.dao.UserMapper;
import sinosoft.domain.User;

import javax.annotation.Resource;

/**
 * @Author 王江超
 * @Date 2020/3/5 23:12
 * @Description:
 */
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

     public int addUser(String username){
         String  pwd = new Md5Hash("123456", username, 3).toString();
         return userMapper.addUser(username,pwd);
     }


     public User findByName(String name){
         return userMapper.findByName(name);
     }
}
