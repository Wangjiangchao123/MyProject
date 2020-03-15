package com.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@Api(tags = "poi优化")
@Slf4j
public class OptimizeController {

    @PostMapping("optimize/import")
    @ApiOperation(value = "优化poi导入",httpMethod = "POST")
    public ResponseEntity  optimizePoiImport(@RequestParam MultipartFile file){

        try {
            SXSSFWorkbook wb = new SXSSFWorkbook(new XSSFWorkbook(file.getInputStream()));
            for (int i = 0; i < wb.getNumberOfSheets(); i++) {
                SXSSFSheet sheet = wb.getSheetAt(i);
                List<List<String>> sheetList = new ArrayList();
                //获取每行
                for (int j = 0; j < sheet.getPhysicalNumberOfRows(); j++) {
                    SXSSFRow row = sheet.getRow(j);
                    List<String> rowlist = new ArrayList();
                    for (int k = 0; k < row.getPhysicalNumberOfCells(); k++) {
                        rowlist.add(String.valueOf(row.getCell(k)));
                    }
                    log.info("输出每一行的数据");
                    sheetList.add(rowlist);
                    log.info("输出所有的数据"+sheetList);
                }
            }

        } catch (IOException e) {
            log.error("excel解析错误");
        }
        return ResponseEntity.status(200).body("导入成功");
    }



}
