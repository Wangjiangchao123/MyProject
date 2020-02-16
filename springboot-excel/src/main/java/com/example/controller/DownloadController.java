package com.example.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.example.util.FileUtil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.example.util.ExcelStyle.styleWrite;
import static com.example.util.FileManager.downloadFile;
import static com.example.util.FileUtil.createNewFile;

/**
 * @Author 王江超
 * @Date 2019/12/24 16:58
 * @Description:
 */
@RestController
@Api(tags = "excel下载")
@Slf4j
public class DownloadController {

    @GetMapping("/download")
    public void download(HttpServletResponse response) throws IOException {
        String fileName = "99" + ".xlsx";
        createNewFile(fileName);
        //创建文件
        String file = FileUtil.getPath() + fileName;
        //使用easyexcel 进行文件导出
        ExcelWriter excelWriter = EasyExcel.write(file).build();
        //不同表头  无对象的写入
        List<String> result = result();
        log.info("sheet页数据"+ result);
        log.info("表头数据"+head());
        for (int i = 0; i < result.size(); i++) {
            WriteSheet writeSheet = EasyExcel
                    .writerSheet(i, result.get(i))
                    .registerWriteHandler(styleWrite())
                    .head(head())
                    .build();
            List<String> data = new ArrayList<>();
            excelWriter.write(data, writeSheet);
        }
        excelWriter.finish();
        downloadFile(response,file);
    }


    /**
     * sheet 页
     * @return
     */
    public List<String>  result(){
        List<String> list1 = new ArrayList<>();
        list1.add("第一页");
        list1.add("第二页");
        list1.add("第三页");
        list1.add("第四页");
        return list1;
    }


    /**
     * 表头
     * @return
     */
    private List<List<String>> head() {
        List<List<String>> list = new ArrayList<List<String>>();

        List<String> head0 = new ArrayList<String>();
        head0.add("姓名");
        List<String> head1 = new ArrayList<String>();
        head1.add("年龄");
        List<String> head2 = new ArrayList<String>();
        head2.add("性别");
        List<String> head3 = new ArrayList<String>();
        head3.add("籍贯");

        list.add(head0);
        list.add(head1);
        list.add(head2);
        list.add(head3);
        return list;
    }

}
