package com.wang.demo.handler;

import com.wang.demo.entity.PoiEntity;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.usermodel.XSSFComment;

/**
 * @Author 王江超
 * @Date 2020/2/28 13:18
 * @Description:  自定义每一行数据读取
 *                  实现接口
 */
public class SheetHandler implements XSSFSheetXMLHandler.SheetContentsHandler {


    private PoiEntity entity;


    /**
     * 当开始解析某一行的时候触发
     * @param i
     */
    public void startRow(int i) {
        //实例化对象
        if (i > 0){
            entity = new PoiEntity();
        }

    }

    public void endRow(int i) {

    }

    public void endSheet() {

    }

    public void cell(String s, String s1, XSSFComment xssfComment) {

    }
}
