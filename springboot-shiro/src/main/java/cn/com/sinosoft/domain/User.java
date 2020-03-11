package cn.com.sinosoft.domain;

import lombok.Data;

/**
 * @Author 王江超
 * @Date 2020/3/5 23:20
 * @Description:
 */
@Data
public class User {

    private int id;

    private String userName;

    private String password;

    private Role roles;
}
