package sinosoft.service;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @Author 王江超
 * @Date 2020/3/9 11:47
 * @Description:
 */
public class Pwd {

    public static void main(String[] args) {
        String  pwd = new Md5Hash("123456", "lisi", 3).toString();

        System.out.println(pwd);

    }

}
