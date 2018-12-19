package com.zzy.io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * FileRead TODO
 * @author zhaizhiyang
 * @date 2018/12/19  14:58
 **/
public class FileRead {

    public static void main(String[] args) {
        Date startTime = new Date();
        readFile("D:\\data\\logs\\srt-yshj-info-2018-12-14-1.log","D:\\data\\logs\\write.log");
        System.out.println(System.currentTimeMillis() - startTime.getTime());
    }

    /**
     * 根据路径读取一个文件
     * @param path
     */
    public static void readFile(String path,String writePath) {
        BufferedReader bf = null;
        try {

            bf = new BufferedReader(new InputStreamReader(new BufferedInputStream(new FileInputStream(new File(writePath)))), 5 * 1024 * 1024);
//            bw = new BufferedWriter(new FileWriter(new File()));
            String line = null;
            List<String> list = new ArrayList<>();

            while (null != (line = bf.readLine())) {
                list.add(line);
                if (list.size() == 100) {
                    System.out.println(list.toArray());
                    list.clear();
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
