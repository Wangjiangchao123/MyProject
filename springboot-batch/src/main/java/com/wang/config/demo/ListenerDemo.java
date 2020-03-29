package com.wang.config.demo;

import com.wang.config.listener.MyChunkListener;
import com.wang.config.listener.MyJobListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableBatchProcessing
public class ListenerDemo {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job listenerJob(){
        return jobBuilderFactory.get("listenerJob")
                .start(step1())
                .listener(new MyJobListener())
                .build();
    }

    @Bean
    public Step step1(){
        return stepBuilderFactory.get("step1")
                //chunk(2) 每读完2个数据进行数据输出  -读数据  写数据  处理数据
                .<String,String>chunk(2)
                .faultTolerant()
                .listener(new MyChunkListener())
                //读数据
                .reader(read())
                //写数据
                .writer(writer())
                .build();
    }

    @Bean
    public ItemWriter<String> writer() {
        return new ItemWriter<String>() {
            //输出数据
            @Override
            public void write(List<? extends String> items) throws Exception {
                for (String item:items) {
                    System.out.println(item);
                }
            }
        };
    }

    @Bean
    public ItemReader<String> read() {
        return new ListItemReader<>(Arrays.asList("Java","Spring","Mybatis"));
    }

}
