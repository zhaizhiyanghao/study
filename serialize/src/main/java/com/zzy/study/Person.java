package com.zzy.study;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author zhiyang.zhai
 * @Date 2018/12/16/016  15:29
 **/
public class Person implements Serializable{
//    private static final long serialVersionUID = 123123123425423L;

    private String name;

    private int age;


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
