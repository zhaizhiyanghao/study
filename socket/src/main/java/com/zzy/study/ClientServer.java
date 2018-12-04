package com.zzy.study;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @Description TODO
 * @Author zhiyang.zhai
 * @Date 2018/12/4/004  22:13
 **/
public class ClientServer {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1",8888);
            PrintWriter print = new PrintWriter(socket.getOutputStream(),true);
            print.print("hello world!");
            print.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
