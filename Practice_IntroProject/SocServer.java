// package Practice_IntroProject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocServer {

    public static void main(String[] args) {
        try {
            System.out.println("Server Started and waiting for the client to connect!");
            int port = 9999;
            ServerSocket ss = new ServerSocket(9999);
            Socket s = ss.accept();
            System.out.println("S : Client Connected Successfully!");

            // Getting the data send by the client:
            BufferedReader bf = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String line = bf.readLine();
            System.out.println("Client : " + line);

            //Sending the data back to the client:
            String newValue = line.substring(0, 3); // first three characters
            OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
            PrintWriter out = new PrintWriter(os);
            out.println(newValue);
            out.flush(); // while sending we need to flush always.
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    
}
