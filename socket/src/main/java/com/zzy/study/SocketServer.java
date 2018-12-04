package com.zzy.study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
            server = new ServerSocket(8888);
            Socket socket = server.accept();
            BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(bf.readLine());
            bf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
