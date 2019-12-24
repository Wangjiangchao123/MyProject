package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author 王江超
 * @Date 2019/12/14 14:29
 * @Description:
 */
@RestController
public class WebWriterController {


    @GetMapping("/download")
    public void download(HttpServletResponse response){}








}
