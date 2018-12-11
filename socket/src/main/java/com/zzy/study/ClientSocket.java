package com.zzy.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @Description TODO
 * @Author zhiyang.zhai
 * @Date 2018/12/4/004  22:13
 **/
public class ClientSocket {
    public static void main(String[] args) {

        try {
            Socket socket  = new Socket("127.0.0.1",8886);
            //读取服务端数据
            BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //往服务端发送数据
            PrintWriter pw  = new PrintWriter(socket.getOutputStream(),true);
            pw.println("hello world!");

            while (true) {
                String serverData = bf.readLine();
                if (serverData == null) {
                    break;
                }
                System.out.println(serverData);
            }
            pw.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
