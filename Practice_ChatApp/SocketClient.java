// package Practice_ChatApp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient {
    public static void main(String[] args) {
        try {
            int port = 9998;
            Socket s = new Socket("localhost", 9998);
            System.out.println("Client Started and Waiting for the server!");

            // chat App:
            Scanner sc = new Scanner(System.in);
            OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
            while (true) {
                PrintWriter out = new PrintWriter(os);
                String input = sc.nextLine();
                if (input.equals("Exit") || input.equals("exit")) {
                    System.out.println("C : Client Exited the Chat!");
                    sc.close();
                    s.close();
                    return;
                }
                out.println(input);
                out.flush();

                // printing the data getting:
                BufferedReader bf = new BufferedReader(new InputStreamReader(s.getInputStream()));
                String line = bf.readLine();
                System.out.println("S : " + line);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
