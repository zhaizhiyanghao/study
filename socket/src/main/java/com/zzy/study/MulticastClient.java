package com.zzy.study;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

/**
 * @Description 组播客户端1
 * @Author zhiyang.zhai
 * @Date 2018/12/13/013  22:47
 **/
public class MulticastClient {
    public static void main(String[] args) {
        try {
            InetAddress group = InetAddress.getByName("224.5.6.7");
            MulticastSocket socket = new MulticastSocket(9999);
            //加入同一组
            socket.joinGroup(group);
            byte[] bytes = new byte[256];
            while (true) {
                //接受来自服务端的数据
                DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
                socket.receive(datagramPacket);
                String data = new String(datagramPacket.getData());
                System.out.println(data);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
