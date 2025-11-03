import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocket {
    public static void main(String[] args) throws Exception {
        String ip = "localhost";
        int port = 9999;
        Socket s = new Socket(ip, port);

        // Send first message to server before reading
        OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
        PrintWriter out = new PrintWriter(os);
        out.println("Chat Started with Client!");
        out.flush();

        BufferedReader bf = new BufferedReader(new InputStreamReader(s.getInputStream()));

        Scanner sc = new Scanner(System.in);
        while (true) {
            String output = bf.readLine();
            System.out.println(output);

            String newLine = sc.nextLine();
            if (newLine.equals("exit") || newLine.equals("Exit") || newLine.equals("EXIT")) {
                out.println("Client Exiting!");
                out.flush();
                sc.close();
                s.close();
                return;
            }
            out.println("Client : " + newLine);
            out.flush();
        }

    }

}