package com.wang.demo.controller;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author 王江超
 * @Date 2020/2/18 21:45
 * @Description:
 */
public class PoiTest02 {

    public static void main(String[] args) throws IOException {
        //1、创建工作簿
        Workbook wb = new XSSFWorkbook();
        //2、创建Sheet页
        Sheet sheet = wb.createSheet("test");
        Row row = sheet.createRow(3);
        Cell cell = row.createCell(3);
        cell.setCellValue("wangjaingchao");
        //文件流
        FileOutputStream pis = new FileOutputStream("D:\\Test\\test.xlsx");

        //写入文件
        wb.write(pis);
        pis.close();
    }


}
