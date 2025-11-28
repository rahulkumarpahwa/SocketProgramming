package DatagramSocket_Other;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    public static void main(String[] args) throws Exception {
        System.out.println("UDP Client Started");

        // Create DatagramSocket for client
        DatagramSocket clientSocket = new DatagramSocket();

        // Server details
        InetAddress serverAddress = InetAddress.getByName("localhost");
        int serverPort = 9876;

        // Message to send
        String message = "Apple";
        System.out.println("Sending to server: " + message);

        // Convert message to bytes and create packet
        byte[] sendBuffer = message.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(
                sendBuffer,
                sendBuffer.length,
                serverAddress,
                serverPort);

        // Send packet to server
        clientSocket.send(sendPacket);

        // Prepare buffer to receive response
        byte[] receiveBuffer = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);

        // Receive response from server
        clientSocket.receive(receivePacket);

        // Extract and display response
        String serverResponse = new String(receivePacket.getData(), 0, receivePacket.getLength());
        System.out.println("Response from server: " + serverResponse);

        // Close socket
        clientSocket.close();
        System.out.println("Client finished.");
    }
}
