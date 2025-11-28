package DatagramSocket_Other;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {
    public static void main(String[] args) throws Exception {
        System.out.println("UDP Server Started on port 9876");

        // Create DatagramSocket to listen on port 9876
        DatagramSocket serverSocket = new DatagramSocket(9876);

        byte[] receiveBuffer = new byte[1024];
        byte[] sendBuffer;

        while (true) {
            // Receive packet from client
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            serverSocket.receive(receivePacket);

            // Extract data from packet
            String clientMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
            InetAddress clientAddress = receivePacket.getAddress();
            int clientPort = receivePacket.getPort();

            System.out.println("Received from client (" + clientAddress + ":" + clientPort + "): " + clientMessage);

            // Process the message - extract first 3 characters
            String response;
            if (clientMessage.length() >= 3) {
                response = clientMessage.substring(0, 3).toUpperCase();
            } else {
                response = clientMessage.toUpperCase();
            }

            System.out.println("Sending response: " + response);

            // Send response back to client
            sendBuffer = response.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(
                    sendBuffer,
                    sendBuffer.length,
                    clientAddress,
                    clientPort);
            serverSocket.send(sendPacket);

            // Break after one exchange (remove this for continuous server)
            System.out.println("Transaction completed. Server shutting down.\n");
            break;
        }

        serverSocket.close();
    }
}
