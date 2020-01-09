package com.example.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author 王江超
 * @Date 2020/1/7 14:01
 * @Description:
 */
@RestController
@Api(tags = "同步数据")
public class ExectorController {



    @PostMapping("/export")
    public String exportData(@RequestParam MultipartFile multipartFile){



        return "";
    }




}
