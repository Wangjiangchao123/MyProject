package com.wang.demo.controller;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author 王江超
 * @Date 2020/2/18 21:45
 * @Description:   单元格样式
 */
public class PoiTest03 {

    public static void main(String[] args) throws IOException {
        //1、创建工作簿
        Workbook wb = new XSSFWorkbook();
        //2、创建Sheet页
        Sheet sheet = wb.createSheet();
        Row row = sheet.createRow(3);
        Cell cell = row.createCell(3);
        cell.setCellValue("王江超");

        //样式处理
        //创建样式对象
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);

        //创建字体对象
        Font font = wb.createFont();
        font.setFontName("宋体");  //设置字体
        font.setFontHeightInPoints((short)28);  //设置字体大小
        cellStyle.setFont(font);

        //设置行高和列宽
        row.setHeightInPoints(50);  //行高
        //列宽  字符宽度
        sheet.setColumnWidth(3,31 * 256);

        //居中显示
        cellStyle.setAlignment(HorizontalAlignment.CENTER);  //水平居中
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);//垂直居中

        cell.setCellStyle(cellStyle);


        //文件流
        FileOutputStream pis = new FileOutputStream("D:\\Test\\test.xlsx");

        //写入文件
        wb.write(pis);
        pis.close();
    }


}
