package com.example.controller;

import com.example.util.FileUtil;
import io.swagger.annotations.Api;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.example.util.FileManager.downloadFile;
import static com.example.util.FileUtil.createNewFile;

/**
 * @Author 王江超
 * @Date 2019/12/25 9:41
 * @Description:
 */
@RestController
@Api(tags = "poi导出excel")
public class PoiController {

    @GetMapping("/poi/download")
    public void poiDownload(HttpServletResponse response) throws IOException {

        String fileName = "789" + ".xls";
        createNewFile(fileName);
        //创建文件
        String file = FileUtil.getPath() + fileName;

        //声明一个工作簿
        HSSFWorkbook hwb = new HSSFWorkbook();
        //sheet命名
        HSSFSheet sheet =  hwb.createSheet("教师信息");
        //给单子名称一个长度
        sheet.setDefaultColumnWidth((short)30);
        //生成一个样式
        HSSFCellStyle cellStyle = hwb.createCellStyle();
        //创建第一行成为表头
        HSSFRow row = sheet.createRow(0);
        //给第一行创建单元格
        HSSFCell cell = row.createCell(0);
        cell.setCellValue("姓名");
        cell.setCellStyle(cellStyle);

        cell = row.createCell(1);
        cell.setCellValue("籍贯");
        cell.setCellStyle(cellStyle);


        downloadFile(response,file);

    }








}
