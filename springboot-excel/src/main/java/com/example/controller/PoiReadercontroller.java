package com.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author 王江超
 * @Date 2020/1/9 14:12
 * @Description:
 */
@RestController
@Slf4j
@Api(tags = "读取excel")
public class PoiReadercontroller {


    @PostMapping("/read/excel")
    @ApiOperation(value ="多excel  不同对象  读取xlsx")
    public ResponseEntity readerExcel(@RequestParam MultipartFile file) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
        XSSFSheet sheet = null;
        List<List<List<String>>> listData = new ArrayList<>();
        //获取每个Sheet表
        List<String> sheetNames = new ArrayList<>();
        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            sheet = workbook.getSheetAt(i);
            String sheetName = sheet.getSheetName();
            //获取所有sheet页的名称
            sheetNames.add(sheetName);
            List<List<String>> sheetList = new ArrayList<>();
            //获取每行
            for (int j = 0; j < sheet.getPhysicalNumberOfRows(); j++) {
                //读取第j行
                XSSFRow row = sheet.getRow(j);
                List<String> rowList = new ArrayList<String>();
                //获取每个单元格
                for (int k = 0; k < row.getPhysicalNumberOfCells(); k++) {
                    //添加第i列
                    rowList.add(String.valueOf(row.getCell(k)));
                }
                sheetList.add(rowList);
            }
            log.info("---Sheet表" + i + "数据：" + sheetList);
            listData.add(sheetList);
        }
        return ResponseEntity.status(200).body("读取成功");
    }



}
