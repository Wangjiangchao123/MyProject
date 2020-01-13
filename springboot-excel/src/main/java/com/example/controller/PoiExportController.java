package com.example.controller;

import com.sun.deploy.net.URLEncoder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.xssf.usermodel.*;
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
    @ApiOperation(value="以xlsx的方式   导出多个文件  压缩下载")
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
                //第几列自动换行
                sheet.autoSizeColumn(1);
                //获取cellStyle的样式
                XSSFCellStyle cellStyle = getXssfCellStyle(wb);

                row.createCell(1).setCellValue("学号");
                XSSFCell cell = row.createCell(0);
                cell.setCellValue("姓名");
                cell.setCellStyle(cellStyle);


                row.createCell(2).setCellValue("设置中文的自动列宽，也不是到对不对");
                row.getCell(2).setCellStyle(cellStyle);

                row.createCell(3).setCellValue("select * from LLToClaimDutyFee where clmno='\" + qLLClaimDetailSchema.getClmNo()");
                row.getCell(3).setCellStyle(cellStyle);
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

    private XSSFCellStyle getXssfCellStyle(XSSFWorkbook wb) {
        //设置样式
        XSSFFont font = wb.createFont();
        font.setFontName("黑体");
        font.setBold(true);
        font.setFontHeightInPoints((short) 20);//设置字体大小

        //总样式
        XSSFCellStyle cellStyle = wb.createCellStyle();
        cellStyle.setFont(font);
        //设置自动换行
        cellStyle.setWrapText(true);

        //设置单元格  位置
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        //设置边框
        cellStyle.setBorderBottom(BorderStyle.DASH_DOT);
        cellStyle.setBorderLeft(BorderStyle.DASH_DOT_DOT);
        cellStyle.setBorderTop(BorderStyle.DASHED);
        cellStyle.setBorderRight(BorderStyle.DOUBLE);
        cellStyle.setBorderLeft(BorderStyle.HAIR);
        cellStyle.setBorderRight(BorderStyle.MEDIUM);




        return cellStyle;
    }

    /**
     *
     * @param response
     * @throws IOException
     */
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




