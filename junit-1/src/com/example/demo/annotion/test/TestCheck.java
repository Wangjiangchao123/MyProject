package com.example.demo.annotion.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author 王江超
 * @Date 2020/2/18 15:19
 * @Description:   简单测试框架
 *
 * 当主方法执行后，会自动执行被检测的所有方法
 */
public class TestCheck {

    public static void main(String[] args) throws IOException {

        //1、创建计算器对象
        Calculator c = new Calculator();
        //2、获取字节码对象
        Class aClass = c.getClass();
        //3、获取所有方法
        Method[] methods = aClass.getMethods();

        int number = 0;
        BufferedWriter bw = new BufferedWriter(new FileWriter("bug.txt"));

        for (Method method:methods) {

            //4、判断方法上是否有Check注解
            if (method.isAnnotationPresent(Check.class)){
                //5、有、执行
                try {
                    method.invoke(c);
                } catch (Exception e) {
                    //捕获异常

                    //记录到文件中
                    number ++;
                    bw.write(method.getName()+"方法出异常了");
                    bw.newLine();
                    bw.write("异常的名称:"+e.getClass().getSimpleName());
                    bw.newLine();
                    bw.write("异常原因"+e.getCause().getMessage());
                    bw.newLine();
                    bw.write("------------------------------------");

                }
            }
        }

        bw.write("本次测试一共出险"+number+"次异常");
        bw.flush();
        bw.close();
    }



}
