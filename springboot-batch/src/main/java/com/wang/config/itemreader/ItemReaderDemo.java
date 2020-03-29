//package com.wang.config.itemreader;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.item.ItemReader;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.Arrays;
//import java.util.List;
//
///**
// * 简单的读
// */
//@Configuration
//public class ItemReaderDemo {
//
//    @Autowired
//    private JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    private StepBuilderFactory stepBuilderFactory;
//
//
//    @Bean
//    public Job itemReaderDemoJob(){
//        return jobBuilderFactory.get("itemReaderDemoJob")
//                .start(itemReaderDemoStep())
//                .build();
//    }
//
//    @Bean
//    public Step itemReaderDemoStep(){
//        return stepBuilderFactory.get("itemReaderDemoStep")
//                .<String,String>chunk(2)
//                .reader(itemReaderDemoRead())
//                .writer(list -> {
//                    for (String item : list){
//                        System.out.println(item+"......");
//                    }
//                }).build();
//    }
//
//    /**
//     * 读数据的方法
//     * @return
//     */
//    @Bean
//    public MyReader itemReaderDemoRead() {
//
//        List<String> data = Arrays.asList("dat","dog","pig","cat");
//        return new MyReader(data);
//    }
//
//
//}
