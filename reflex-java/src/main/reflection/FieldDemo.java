package main.reflection;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;

public class FieldDemo {

    public static void main(String[] args) {
        User user = new User();

        user.setAddr("河南");
        user.setAge("19");
        user.setSex("1");
        user.setName("李四");
        user.setFamily("西平");
        user.setPwd("1122");
        String[] arr = new String[20];
        convertJson(user,arr);

    }




    public static JSONObject convertJson(Object request, String[] arr) {
        try {
            JSONObject result = new JSONObject();
            if (StringUtils.isNotBlank(request.toString())) {
                //第一步:获取操作类
                Class clazz = request.getClass();
         //第二步：获取此类的所有的公共（public）的字段，返回 Field 对象的一个数组
                Field[] fields = clazz.getFields();
                for (Field field : fields) {
             //第三步：获取字段的名称
                    String fieldValue = field.getName();
                    if(ArrayUtils.contains(arr,fieldValue)){//第四步：将字段名称和值进行存储
                        result.put(fieldValue,field.get(request));
                    }
                }
            }
            return result;
        } catch (Exception ex) {
            return null;
        }
    }


}
