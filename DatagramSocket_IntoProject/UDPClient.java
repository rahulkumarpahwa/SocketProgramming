// package DatagramSocket_IntoProject;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) {
        try {
            // sending data:
            DatagramSocket ds = new DatagramSocket();
            String name = "apple";
            byte[] b = name.getBytes();
            DatagramPacket dp = new DatagramPacket(b, b.length, InetAddress.getLocalHost(), 9999);
            ds.send(dp);


            // receive data:
            byte[] b2 = new byte[1024];
            DatagramPacket dp2 = new DatagramPacket(b2, b2.length);
            ds.receive(dp2);
            String recivedData = new String(dp2.getData(), 0, dp2.getLength());
            System.out.println("Server : " + recivedData);
            ds.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}