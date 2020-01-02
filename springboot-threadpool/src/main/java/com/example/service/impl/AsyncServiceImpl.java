package com.example.service.impl;

import com.example.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Author 王江超
 * @Date 2020/1/2 16:02
 * @Description:
 */
@Service
@Slf4j
public class AsyncServiceImpl  implements AsyncService {

    @Override
    //taskExecutor   中配置线程池的方法
    @Async("taskExecutor")
    public void excuteAsync() {
        log.info("开始执行异步线程");
        System.out.println(""+Thread.currentThread().getName());
        log.info("结束执行异步线程");
    }
}
