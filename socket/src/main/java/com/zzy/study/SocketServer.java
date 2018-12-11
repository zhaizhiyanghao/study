package com.zzy.study;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description 简单的socket 编程
 * @Author zhiyang.zhai
 * @Date 2018/12/4/004  22:05
 **/
public class SocketServer {
    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(8886);
            while (true) {
                Socket socket = server.accept();
                new Thread(() ->{
                    try {
                        // 读取客户端数据
                        BufferedReader bf =  new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        // 回复客户消息
                        PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

                        while (true) {
                            String clientData = bf.readLine();
                            if (clientData == null) {
                                break;
                            }
                            System.out.println(clientData);

                            pw.println("hello client");
                            pw.flush();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
