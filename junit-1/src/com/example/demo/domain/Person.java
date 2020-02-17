package com.example.demo.domain;

/**
 * @Author 王江超
 * @Date 2020/2/16 17:52
 * @Description:
 */
public class Person {

    private String name;

    private int age;

    //    public String a;
//    protected  String b;
//    String c;
//    private String d;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
//    public String a;
//    protected  String b;
//    String c;
//    private String d;


    public Person(String name, int age) {

        this.name = name;
        this.age = age;
    }


    public Person() {
    }

    public void eat(){
        System.out.println("吃。。。。。");
    }
}
