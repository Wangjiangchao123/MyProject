//package com.wang.config.itemreader;
//
//import com.wang.entity.User;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepScope;
//import org.springframework.batch.item.ItemReader;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.batch.item.database.JdbcPagingItemReader;
//import org.springframework.batch.item.database.Order;
//import org.springframework.batch.item.database.support.MySqlPagingQueryProvider;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.core.RowMapper;
//
//import javax.sql.DataSource;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * 从数据中读取文件
// */
//@Configuration
//public class ItemReaderDBDemo {
//
//    @Autowired
//    private JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    private StepBuilderFactory stepBuilderFactory;
//
//    @Autowired
//    private DataSource dataSource;
//
//    @Autowired
//    @Qualifier("dbJdbcWriter")
//    private ItemWriter<? super User> dbJdbcWriter;
//
//    @Bean
//    public Job itemReaderDbJob() {
//        return jobBuilderFactory.get("itemReaderDbJob")
//                .start(itemReaderDbStep())
//                .build();
//    }
//
//    @Bean
//    public Step itemReaderDbStep() {
//        return stepBuilderFactory.get("itemReaderDbStep")
//                .<User, User>chunk(2)
//                .reader(dbJdbcReader())
//                .writer(dbJdbcWriter)
//                .build();
//    }
//
//    @Bean
//    @StepScope
//    public JdbcPagingItemReader<User> dbJdbcReader() {
//        JdbcPagingItemReader reader = new JdbcPagingItemReader<User>();
//        reader.setDataSource(dataSource);
//        reader.setFetchSize(2);
//        //把读取到的记录转换成User对象
//        reader.setRowMapper(new RowMapper<User>() {
//
//            @Override
//            public User mapRow(ResultSet resultSet, int i) throws SQLException {
//                User user = new User();
//                user.setId(resultSet.getInt(1));
//                user.setName(resultSet.getString(2));
//                user.setAge(resultSet.getInt(3));
//                user.setAddress(resultSet.getString(4));
//                return user;
//            }
//        });
//        //指定sql语句
//        MySqlPagingQueryProvider provider = new MySqlPagingQueryProvider();
//        provider.setSelectClause("id,name,age,address");
//        provider.setFromClause("from user");
//
//        //根据哪个字段进行排序
//        Map<String, Order> sort = new HashMap<>(1);
//        sort.put("id",Order.ASCENDING);
//        provider.setSortKeys(sort);
//        reader.setQueryProvider(provider);
//        return reader;
//    }
//
//
//}
