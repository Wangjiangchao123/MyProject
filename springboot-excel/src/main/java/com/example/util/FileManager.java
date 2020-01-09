package com.example.util;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @Author: 王江超
 * @Date: 2019/12/16 11:02
 * @Description:
 */
@Slf4j
public class FileManager {


    /**
     * @param response
     * @param path     全路径
     * @throws IOException
     */
    public static void downloadFile(HttpServletResponse response, String path) throws IOException {
        log.info("#################下载开始");
        // 获取文件名
        File tempFile = new File(path.trim());
        String fileName = tempFile.getName();
        //1、设置响应的头文件，会自动识别文件内容
        response.setContentType("application/vnd.ms-excel");
        //2、设置Content-Disposition
        response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("utf-8"), "ISO8859-1"));
        OutputStream out = null;
        InputStream in = null;
        try {
            //3、输出流
            out = response.getOutputStream();

            //4、获取服务端生成的excel文件，这里的path等于4.8中的path
            in = new FileInputStream(new File(path));

            //5、输出文件
            int b;
            while ((b = in.read()) != -1) {
                out.write(b);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            in.close();
            out.close();

        }
        log.info("#################下载完成");
    }


    public static void download(HttpServletResponse response, String filePath, String fileName) throws IOException {
        FileInputStream fis = null;
        OutputStream os = null;

        try {
            //全路径
            String filefull = filePath + File.separator + fileName;
            File file = new File(filefull);
            if (!file.exists()) {
                System.out.println("文件下载失败：文件或路径错误");

            }
            fis = new FileInputStream(file);
            // 取得输出流
            os = response.getOutputStream();
            // 清空输出流
            response.reset();
            // 设定输出文件头
            response.setHeader("Content-disposition", "attachment; filename=" + new String(fileName.getBytes("GBK"), "ISO8859_1"));
            response.setContentType("application/x-download");
            byte[] mybyte = new byte[8192];
            int len = 0;
            while ((len = fis.read(mybyte)) != -1) {
                os.write(mybyte, 0, len);
            }
            fis.close();
            os.close();
        } catch (Exception e) {
            fis.close();
            os.close();
            e.printStackTrace();
        }

    }

}