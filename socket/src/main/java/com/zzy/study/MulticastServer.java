package com.zzy.study;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

/**
 * @Description 组播服务
 * @Author zhiyang.zhai
 * @Date 2018/12/13/013  22:28
 **/
public class MulticastServer {

    public static void main(String[] args) {
        try {
            InetAddress gourp = InetAddress.getByName("224.5.6.7");
            MulticastSocket socket = new MulticastSocket();

            for (int i = 0; i <100 ; i++) {
                String data = "hello baby!";
                byte[] bytes = data.getBytes();
                socket.send(new DatagramPacket(bytes,bytes.length,gourp,9999));
                TimeUnit.SECONDS.sleep(2);
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
