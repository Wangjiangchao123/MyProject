//package com.wang.config.itemreader;
//
//import com.wang.entity.User;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component("dbJdbcWriter")
//public class DbJdbcWriter implements ItemWriter<User> {
//    @Override
//    public void write(List<? extends User> list) throws Exception {
//        for (User user:list) {
//            System.out.println(user);
//        }
//    }
//}
