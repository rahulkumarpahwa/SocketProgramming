// package Practice_ChatApp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SocSocket {
    public static void main(String[] args) {
        try {
            System.out.println("Server started and waiting for client to connect!");
            int port = 9998;
            ServerSocket ss = new ServerSocket(port);
            Socket s = ss.accept();

            // chat app:
            OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
            Scanner sc = new Scanner(System.in);
            while (true) {
                // printing the client:
                BufferedReader bf = new BufferedReader(new InputStreamReader(s.getInputStream()));
                String line = bf.readLine();
                System.out.println("S : " + line);

                PrintWriter out = new PrintWriter(os);
                String input = sc.nextLine();
                if (input.equals("Exit") || input.equals("exit")) {
                    System.out.println("S : Server Exited the Chat!");
                    sc.close();
                    s.close();
                    return;
                }
                out.println(input);
                out.flush();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
