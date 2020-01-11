//package com.example.service;
//
//import com.alibaba.excel.EasyExcel;
//import com.alibaba.excel.ExcelWriter;
//import com.alibaba.excel.write.metadata.WriteSheet;
//import org.springframework.stereotype.Service;
//
//import javax.servlet.http.HttpServletResponse;
//
///**
// * @Author 王江超
// * @Date 2019/12/14 14:30
// * @Description:
// */
//@Service
//public class WriterService {
//
//    public void writerExcel(HttpServletResponse response){
//
//        // 方法1 如果写到同一个sheet
//        String fileName = TestFileUtil.getPath() + "repeatedWrite" + System.currentTimeMillis() + ".xlsx";
//        // 这里 需要指定写用哪个class去写
//        ExcelWriter excelWriter = EasyExcel.write(fileName, DemoData.class).build();
//        // 这里注意 如果同一个sheet只要创建一次
//        WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
//        // 去调用写入,这里我调用了五次，实际使用时根据数据库分页的总的页数来
//        for (int i = 0; i < 5; i++) {
//            // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
//            List<DemoData> data = data();
//            excelWriter.write(data, writeSheet);
//        }
//        /// 千万别忘记finish 会帮忙关闭流
//        excelWriter.finish();
//
//        // 方法2 如果写到不同的sheet 同一个对象
//        fileName = TestFileUtil.getPath() + "repeatedWrite" + System.currentTimeMillis() + ".xlsx";
//        // 这里 指定文件
//        excelWriter = EasyExcel.write(fileName, DemoData.class).build();
//        // 去调用写入,这里我调用了五次，实际使用时根据数据库分页的总的页数来。这里最终会写到5个sheet里面
//        for (int i = 0; i < 5; i++) {
//            // 每次都要创建writeSheet 这里注意必须指定sheetNo
//            writeSheet = EasyExcel.writerSheet(i, "模板").build();
//            // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
//            List<DemoData> data = data();
//            excelWriter.write(data, writeSheet);
//        }
//        /// 千万别忘记finish 会帮忙关闭流
//        excelWriter.finish();
//
//        // 方法3 如果写到不同的sheet 不同的对象
//        fileName = TestFileUtil.getPath() + "repeatedWrite" + System.currentTimeMillis() + ".xlsx";
//        // 这里 指定文件
//        excelWriter = EasyExcel.write(fileName).build();
//        // 去调用写入,这里我调用了五次，实际使用时根据数据库分页的总的页数来。这里最终会写到5个sheet里面
//        for (int i = 0; i < 5; i++) {
//            // 每次都要创建writeSheet 这里注意必须指定sheetNo。这里注意DemoData.class 可以每次都变，我这里为了方便 所以用的同一个class 实际上可以一直变
//            writeSheet = EasyExcel.writerSheet(i, "模板").head(DemoData.class).build();
//            // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
//            List<DemoData> data = data();
//            excelWriter.write(data, writeSheet);
//        }
//        /// 千万别忘记finish 会帮忙关闭流
//        excelWriter.finish();
//
//
//    }
//
//
//
//
//
//}
