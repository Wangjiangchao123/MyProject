package com.example.controller;

import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 王江超
 * @Date 2020/1/14 9:50
 * @Description:
 */
@RestController
@Api(tags = "easyexcel 2.1.4使用")
public class EasyExcelController {

    @GetMapping("/excel/export")
    public ResponseEntity exportExcel(){


        return ResponseEntity.status(200).body("导出完成");
    }






}
