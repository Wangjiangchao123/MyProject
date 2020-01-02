package com.example.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @Author 王江超
 * @Date 2020/1/2 14:11
 * @Description:
 */
@Component
@Slf4j
public class TestThread {

    @Async
    public void  sayHello(String name){
        log.info(name+":Hello World!");
    }




}
