package com.wang.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 王江超
 * @Date 2020/2/24 19:53
 * @Description:
 */
@RestController
public class UserController {

    /**
     * 参数采用变量导出
     * @param month
     */
    @GetMapping("/export/{month}")
    public void export(@PathVariable String month){



    }













}

