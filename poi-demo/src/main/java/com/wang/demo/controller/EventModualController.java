package com.wang.demo.controller;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 王江超
 * @Date 2020/2/28 13:25
 * @Description:
 */
@RestController
public class EventModualController {

    /**
     * 事件模式   读取百万报表
     * @param args
     */
    public static void main(String[] args) throws Exception {

        String path = "";
        //1、根据excel报表获取OPCPackage
        OPCPackage open = OPCPackage.open(path, PackageAccess.READ);
        //2、创建XSSFReader
        XSSFReader xssfReader = new XSSFReader(open);
        //3、获取ShareStringTable对象

        //4、获取styleTable对象

        //5、创建Sax的xmlReader对象

        //6、注册事件处理器

        //7、逐行读取












    }













}
