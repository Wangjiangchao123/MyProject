package com.example.demo.reflect;

import com.example.demo.domain.Person;

import java.lang.reflect.Constructor;

/**
 * @Author 王江超
 * @Date 2020/2/16 17:28
 * @Description:
 */
public class ReflectDemo2 {

    /**
     * 1、获取成员变量 Field
     *  Field[] getFields()     获取public修饰的成员变量
     *  Field getField(String name);  获取指定名称的  public修饰的成员变量
     *
     * Field[] getDeclareFields()    获取所有成员变量， 不考虑修饰符
     * Field getDeclareField(String name)   获取指定名称的成员变量  不考虑修饰符
     *
     * 2、获取构造方法
     *   Constructor<?>[] getConstructors()
     *   Constructor<T> getConstructor(类<?>... parameterTypes)
     *
     *   Constructor<T> getDeclareConstructor(类<?>... parameterTypes)
     *   Constructor<?>[] getDeclareConstructors()
     * 3、获取成员方法
     *   Method[] getMethods()
     *   Method getMethod(String name,类<?>... parameterType </>);
     *
     *   Method getDeclareMethods()
     *   Method getDeclareMethod(String name,类<?>... paramterTypes)
     *
     *
     * 4、获取类名
     *
     *   String getName();
     *
     */

    public static void main(String[] args) throws Exception {

        //1、 获取person的Class对象
        Class personClass = Person.class;

        //2、获取构造方法   Constructor
        Constructor constructor = personClass.getConstructor(String.class, int.class);

        //创建对象
        Object instance = constructor.newInstance("张三", 23);
        System.out.println(instance);


    }

}
