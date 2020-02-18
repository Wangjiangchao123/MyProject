package com.example.demo.annotion;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @Author 王江超
 * @Date 2020/2/17 22:15
 * @Description:  框架类   -->  半成品软件  不能改变该类的任何代码
 */
@Pro(className = "com.example.demo.annotion.Demo1",methodName = "show")
public class ReflectTest {

    public static void main(String[] args) throws IOException, Exception {
        //可以创建任意对象，执行任意方法


        /*
            前提：不能改变 该类的任何代码  可以帮助我们创建任意类的对象 ，并且执行任意方法
         */

        //1、解析注解
        //1.1  获取该类的字节码文件对象
        Class<ReflectTest> reflectTestClass = ReflectTest.class;
        //1.2 获取上边的注解对象
        Pro pro = reflectTestClass.getAnnotation(Pro.class); //在内存中生成了一个该注解接口的子类实现对象
        //1.3  调用注解对象的抽象方法  获取返回值
        String className = pro.className();
        String methodName = pro.methodName();

        //3、加载该类进内存
        Class aClass = Class.forName(className);

        //4、创建对象
        Object o = aClass.newInstance();

        //5、获取方法对象
        Method method = aClass.getMethod(methodName);

        //6、执行方法
        method.invoke(o);


    }







}
