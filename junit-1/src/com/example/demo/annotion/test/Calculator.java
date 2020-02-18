package com.example.demo.annotion.test;

/**
 * @Author 王江超
 * @Date 2020/2/18 15:11
 * @Description:
 */
public class Calculator {


    @Check
    public void add(){
        System.out.println("1 + 0 ="+(1+0));
    }

    @Check
    public void sub(){
        System.out.println("1 - 0 ="+(1-0));
    }
    @Check
    public void mul(){
        System.out.println("1 * 0 ="+(1*0));
    }
    @Check
    public void div(){
        System.out.println("1 / 0 ="+(1/0));
    }



    public void show(){
        System.out.println("永无bug。。。");
    }

}
