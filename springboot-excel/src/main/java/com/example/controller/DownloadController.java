package com.example.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author 王江超
 * @Date 2019/12/24 16:58
 * @Description:
 */
@RestController
@Api(tags = "excel下载")
public class DownloadController {

    @GetMapping("/download")
    public void download(HttpServletResponse response){




    }



}
