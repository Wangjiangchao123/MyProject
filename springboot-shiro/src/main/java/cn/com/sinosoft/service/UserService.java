package cn.com.sinosoft.service;

import cn.com.sinosoft.domain.User;
import org.springframework.stereotype.Service;

/**
 * @Author 王江超
 * @Date 2020/3/5 23:12
 * @Description:
 */
@Service
public interface UserService {

    User findByName(String username);
}
