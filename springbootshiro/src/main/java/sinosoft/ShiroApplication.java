package sinosoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author 王江超
 * @Date 2020/3/5 22:33
 * @Description:
 */
@SpringBootApplication
@MapperScan(basePackages = {"sinosoft.dao"})
public class ShiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiroApplication.class,args);
    }


}
