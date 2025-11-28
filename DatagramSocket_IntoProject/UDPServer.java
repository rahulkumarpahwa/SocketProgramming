// package DatagramSocket_IntoProject;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {

    public static void main(String[] args) {
        try {
            // recieving data
            DatagramSocket ds = new DatagramSocket(9999);
            byte[] reciverbuffer = new byte[1024];
            DatagramPacket dp = new DatagramPacket(reciverbuffer, reciverbuffer.length);
            ds.receive(dp);
            String str = new String(dp.getData(), 0, dp.getLength());
            System.out.println("Client : " + str);  

            // sending data
            String sendback = str.toUpperCase().substring(0, 3); // first three characters in UPPERCASE
            byte[] sendBuffer = sendback.getBytes();
            DatagramPacket dp2 = new DatagramPacket(sendBuffer, sendBuffer.length, dp.getAddress(),
                    dp.getPort());
            ds.send(dp2);
            ds.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}