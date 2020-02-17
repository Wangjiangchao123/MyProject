package com.example.demo.reflect;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @Author 王江超
 * @Date 2020/2/17 22:15
 * @Description:  框架类   -->  半成品软件  不能改变该类的任何代码
 */
public class ReflectTest {

    public static void main(String[] args) throws IOException, Exception {
        //可以创建任意对象，执行任意方法


        /*
          不能改变 该类的任何代码  可以帮助我们创建任意类的对象 ，并且执行任意方法

          实现：
                1、配置文件
                2、反射

            步骤：
                1、将需要创建的对象的 全类名  和需要     执行的方法  定义在配置文件中
                2、在程序中加载读取配置文件
                3、使用反射技术来加载类文件进内存中
                4、创建对象
                5、执行方法
         */

        //1、加载配置文件
        //1 创建Properties 对象
        Properties properties = new Properties();
        //1.2 加载配置文件转换成一个集合
        //1.2.1  获取class下的配置文件
        ClassLoader classLoader = ReflectTest.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("pro.properties");
        properties.load(resourceAsStream);


        //2、 获取配置文件中定义的数据
        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");


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
