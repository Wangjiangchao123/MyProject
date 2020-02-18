package com.example.demo.annotion;

import java.lang.annotation.*;

/**
 * @Author 王江超
 * @Date 2020/2/18 8:57
 * @Description:
 */
@Target(value = {ElementType.TYPE,ElementType.FIELD,ElementType.METHOD})   //表示MyAnno3  只能作用在类上
@Retention(RetentionPolicy.RUNTIME)      // 当前被描述的注解，会保留到class字节码文件中 ，并被Jvm读取到。
@Documented
@Inherited    // 自动被子类继承
public @interface MyAnno3 {




}



