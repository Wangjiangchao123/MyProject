package com.example.demo.reflect;

import com.example.demo.domain.Person;

import java.lang.reflect.Field;

/**
 * @Author 王江超
 * @Date 2020/2/16 17:28
 * @Description:
 */
public class ReflectDemo1 {

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
        /*
        1、获取成员变量
     *  Field[] getFields()   获
     *  取public的成员变量
     *  Field getField(String name);
     *
     * Field[] getDeclareFields()
     * Field getDeclareField(String name)
         */
        //1、Field[] getFields() 获取public成员变量
        Field[] fields = personClass.getFields();
        for (Field field: fields) {
            System.out.println(field);
        }

        System.out.println("-------");
        Field a = personClass.getField("a");
        //获取成员变量a的值
        Person p = new Person();
        Object value = a.get(p);
        System.out.println(value);

        //设置a的值
        a.set("p","张三");
        System.out.println(p);

        //2、获取所有的成员变量，不考虑修饰符
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField:declaredFields) {
            System.out.println(declaredField);
        }
        Field d = personClass.getDeclaredField("a");
        //忽略访问权限修饰符的安全检查
        d.setAccessible(true);  //暴力反射
        Object o = d.get(p);
        System.out.println(o);



    }

}
