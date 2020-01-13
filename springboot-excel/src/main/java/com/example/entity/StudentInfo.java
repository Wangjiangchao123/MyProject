package com.example.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @Author 王江超
 * @Date 2020/1/9 16:37
 * @Description:
 */
@Data
public class StudentInfo {

    @ExcelProperty(value = "姓名", index = 0)
    private String name;

    @ExcelProperty(value = "年龄", index = 1)
    private String age;

    @ExcelProperty(value = "邮箱", index = 2)
    private String email;

    @ExcelProperty(value = "地址", index = 3)
    private String address;

    @ExcelProperty(value = "性别", index = 4)
    private String sax;

    @ExcelProperty(value = "高度", index = 5)
    private String heigh;

    @ExcelProperty(value = "备注", index = 6)
    private String remark;

}
