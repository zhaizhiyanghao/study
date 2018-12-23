package com.zzy.study;

import java.io.*;

/**
 * @Description 序列化工具
 * @Author zhiyang.zhai
 * @Date 2018/12/16/016  15:33
 **/
public class SeriallizeUtil {

    public static void main(String[] args) {
        //SeriallizeUtil.serial();
        SeriallizeUtil.deserial() ;
    }

    /**
     * 序列化
     * @throws IOException
     */
    public static void serial()  {
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(new File("person")));
            Person person = new Person();
            person.setName("zhangsan");
            person.setAge(12);
            outputStream.writeObject(person);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 反序列化
     */
    public static void deserial() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("person"));
            Person person = (Person) objectInputStream.readObject();
            System.out.println(person.getName() + "--" + person.getAge());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
    }
}
