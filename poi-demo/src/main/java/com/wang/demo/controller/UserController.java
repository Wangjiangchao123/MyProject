package com.wang.demo.controller;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author 王江超
 * @Date 2020/2/24 19:53
 * @Description:
 */
@RestController
public class UserController {

    /**
     * 参数采用变量导出   模板打印
     * @param month
     */
    @GetMapping("/export/{month}")
    public void export(@PathVariable String month) throws IOException {


        //2、加载模板
        Resource resource = new ClassPathResource("路径");
        FileInputStream inputStream = new FileInputStream(resource.getFile());
        //读取工作簿
        Workbook wb = new XSSFWorkbook(inputStream);

        Sheet sheet = wb.getSheetAt(0);
        //抽取样式
        Row row = sheet.getRow(2);
        //构造单元格
        CellStyle [] styles = new CellStyle[row.getLastCellNum()];

        //获取单元格的样式
        for (int i = 0; i < row.getLastCellNum(); i++) {
            Cell cell = row.getCell(i);
            CellStyle cellStyle = cell.getCellStyle();
            styles[i] = cellStyle;
        }

        //下载
    }


    /**
     * 百万数据导出
     * 不支持模板打印
     */
    public void  exportMillion(){


        SXSSFWorkbook sb = new SXSSFWorkbook(200);  //阈值，内存中的对象最大数量

        Sheet sheet = sb.createSheet();
    }











}

