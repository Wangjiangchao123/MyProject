package com.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

/**
 * @Author 王江超
 * @Date 2020/2/24 8:50
 * @Description:
 */
public class PoiTest05 {

    /**
     * 解析Excel
     *      sheet
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        //1、根据excel文件创建文件簿
        Workbook wb = new XSSFWorkbook("D:\\Test\\产品配置情况.xlsx");
        //2、获取sheet
        Sheet sheet = wb.getSheetAt(0);
        //3、获取每一行   循环遍历每一行
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);   //根据索引 获取每一行
            StringBuffer sbf = new StringBuffer();
            for (int j = 0; j < row.getLastCellNum(); j++) {
                Cell cell = row.getCell(j);
                //获取每一个单元格的内容
                Object value = getValue(cell);
                sbf.append(value);
            }
            System.out.println(sbf.toString());
        }

    }

    public  static Object getValue(Cell cell){
        //1、获取单元格数据类型
        CellType cellType = cell.getCellType();
        Object value = null;
        //2、根据数据类型获取数据
        switch(cellType){
            case STRING:
                value = cell.getStringCellValue();
                break;
            case NUMERIC:
                //日期格式
                if(DateUtil.isCellDateFormatted(cell)){
                    //日期格式
                    value = cell.getDateCellValue();
                }else{
                    value = cell.getNumericCellValue();
                }
                break;
            case BOOLEAN:
                value = cell.getBooleanCellValue();
                break;
            case FORMULA:  //公式
                value = cell.getCellFormula();
                break;
            default:
                break;
        }
        return value;
    }




}
