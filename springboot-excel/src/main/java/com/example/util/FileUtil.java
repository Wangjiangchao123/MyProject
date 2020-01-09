package com.example.util;

import java.io.File;

/**
 * @Author 王江超
 * @Date 2019/12/13 15:26
 * @Description:
 */
public class FileUtil {
    public static String getPath() {
        return FileUtil.class.getResource("/").getPath() + "static/temp/";
    }

    public static File createNewFile(String pathName) {
        File file = new File(getPath() + pathName);
        if (file.exists()) {
            file.delete();
        } else {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
        }
        return file;
    }

}
