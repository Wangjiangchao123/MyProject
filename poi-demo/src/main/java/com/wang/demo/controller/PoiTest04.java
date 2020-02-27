package com.wang.demo.controller;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author 王江超
 * @Date 2020/2/18 21:45
 * @Description:  插入图片
 */
public class PoiTest04 {

    public static void main(String[] args) throws IOException {
        //1、创建工作簿
        Workbook wb = new XSSFWorkbook();
        //2、创建Sheet页
        Sheet sheet = wb.createSheet("test");


        //1、读取图片流
        FileInputStream inputStream = new FileInputStream("D:\\Test\\0.jpeg");
        //2、转化为二进制流
        byte[] bytes = IOUtils.toByteArray(inputStream);
        inputStream.read(bytes);
        //3、向poi内存中添加一张图片，返回图片在图片集合的索引
        int index = wb.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);

        //4、绘制图片工具类
        CreationHelper helper = wb.getCreationHelper();
        //5、创建一个绘图对象
        Drawing<?> patriarch = sheet.createDrawingPatriarch();
        //6、创建锚点,设置图片的坐标
        ClientAnchor clientAnchor = helper.createClientAnchor();
        //从哪开始
        clientAnchor.setRow1(0);
        clientAnchor.setCol1(0);
        //绘制图片
        Picture picture = patriarch.createPicture(clientAnchor, index);//图片位置  图片索引
        picture.resize();//自适应图片

        //文件流
        FileOutputStream pis = new FileOutputStream("D:\\Test\\test1.xlsx");

        //写入文件
        wb.write(pis);
        pis.close();
    }


}
