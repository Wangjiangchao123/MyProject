package com.example.controller;

import com.sun.deploy.net.URLEncoder;
import io.swagger.annotations.Api;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @Author 王江超
 * @Date 2020/1/9 11:20
 * @Description:
 */
@RestController
@Api(tags = "多excel，压缩导出")
public class PoiExportController {

    /**
     * 以xlsx的方式   导出多个文件  压缩下载
     *
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/poizip")
    public void poizip(HttpServletResponse response) throws IOException {
        //response 输出流
        ServletOutputStream out = response.getOutputStream();
        //压缩输出流
        ZipOutputStream zipOutputStream = new ZipOutputStream(out);
        try {
            for (int i = 0; i < 6; i++) {
                //创建工作簿
                XSSFWorkbook wb = new XSSFWorkbook();
                XSSFSheet sheet = wb.createSheet("sheet" + i);
                XSSFRow row = sheet.createRow(0);

                row.createCell(1).setCellValue("aaa");
                XSSFCell cell = row.createCell(0);
                cell.setCellValue("内容" + i);

                //响应
                response.setContentType("application/zip; charset=utf-8");
                response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode("911.zip", "UTF-8"));

                //重点开始,创建压缩文件
                ZipEntry z = new ZipEntry(i + ".xlsx");
                zipOutputStream.putNextEntry(z);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                wb.write(bos);
                byte[] barray = bos.toByteArray();
                zipOutputStream.write(barray);
                //写入一个压缩文件
//                wb.write(zipOutputStream);

            }
            zipOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //注意关闭顺序，否则可能文件错误
            if (zipOutputStream != null) {
                zipOutputStream.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }


    @RequestMapping(value = "/poizip1")
    public void poizip1(HttpServletResponse response) throws IOException {
        //response 输出流
        ServletOutputStream out = response.getOutputStream();
        //压缩输出流
        ZipOutputStream zipOutputStream = new ZipOutputStream(out);
        try {
            for (int i = 0; i < 6; i++) {
                //创建工作簿
                HSSFWorkbook wb = new HSSFWorkbook();
                HSSFSheet sheet = wb.createSheet("sheet" + i);
                HSSFRow row = sheet.createRow(0);
                HSSFCell cell = row.createCell(0);
                cell.setCellValue("内容" + i);
                response.setContentType("application/octet-stream; charset=utf-8");
                response.setHeader("Content-Disposition", "attachment; filename=" + "111.zip");
                //重点开始,创建压缩文件
                ZipEntry z = new ZipEntry(i + ".xls");
                zipOutputStream.putNextEntry(z);
                //写入一个压缩文件
                wb.write(zipOutputStream);
            }
            zipOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //注意关闭顺序，否则可能文件错误
            if (zipOutputStream != null) {
                zipOutputStream.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

}




